package top.austin.toolkits;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.LongCodec;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

/**
 * @Desc: Redis-Lua脚本工具类
 * @Author: Linbizhao
 * @Since: 2024/1/15 20:39
 */
@Slf4j
@Component
public class RedisLuaTools {

    @Resource
    private RedissonClient redissonClient;

    /**
     * 单号按照keyPrefix+yyyyMMdd+4位流水号的格式生成
     *
     * @param keyPrefix 流水号前缀标识--用作redis key名
     * @return 单号
     */
    public String generateOrder(String keyPrefix) {
        RScript script = redissonClient.getScript(new LongCodec());
        long between = ChronoUnit.SECONDS.between(LocalDateTime.now(), LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
        Long eval = script.eval(RScript.Mode.READ_WRITE,
                "local sequence = redis.call('get', KEYS[1]);if sequence then if sequence > ARGV[1] then sequence " +
                        "= 0 else sequence = sequence+1 end else sequence = 1 end;redis.call('set', KEYS[1], " +
                        "sequence);redis.call('expire',KEYS[1],ARGV[2]);return sequence;",
                RScript.ReturnType.INTEGER, Collections.singletonList(keyPrefix), 9999, between);
        DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
        int len = String.valueOf(eval).length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 4 - len; i++) {
            res.append("0");
        }
        res.append(eval);
        return keyPrefix + yyyyMMdd + res;
    }

    /**
     * @param key        幂等性校验的key
     * @param expireTime 设定一个窗口时间
     * @return 如果不为-1 说明已有请求在当前时间窗口内运行
     */
    public long idempotencyCheck(String key, int expireTime) {
        RScript script = redissonClient.getScript(new LongCodec());
        return script.eval(RScript.Mode.READ_WRITE,
                "local exist = redis.call('get', KEYS[1]);" +
                        "if not exist then " +
                        "redis.call('set', KEYS[1], ARGV[1]);" +
                        "redis.call('expire',KEYS[1],ARGV[1]);" +
                        "exist = -1;" +
                        "end;" +
                        "return exist;",
                RScript.ReturnType.INTEGER, Collections.singletonList(key), expireTime);
    }


}
