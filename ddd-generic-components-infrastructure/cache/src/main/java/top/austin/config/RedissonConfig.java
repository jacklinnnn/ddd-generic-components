package top.austin.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.austin.components.RedisConfigProperties;

/**
 * @Desc: Redisson配置
 * @Author: Linbizhao
 * @Since: 2024/1/15 20:56
 */
@Slf4j
@Configuration
public class RedissonConfig {

    @Resource
    private RedisConfigProperties redisConfigProperties;

    /**
     * 单机配置
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient singleRedisson() {
        log.info("【Redisson配置】：{}", redisConfigProperties);
        Config config = new Config();
        // 对象编码为纯字符串编码
        config.setCodec(StringCodec.INSTANCE);
        config.setTransportMode(TransportMode.NIO);
        config.useSingleServer()
                .setAddress(redisConfigProperties.getHost() + ":" + redisConfigProperties.getPort())
                .setPassword(redisConfigProperties.getPassword());
        return Redisson.create(config);
    }

    ///**
    // * Redis集群
    // */
    //private RedissonClient clusterRedisson() {
    //    log.info("【Redisson配置】：{}", redisConfigProperties);
    //    List<String> clusterNodes = redisConfigProperties.getCluster().getNodeAddress();
    //    Config config = new Config();
    //    // 对象编码为纯字符串编码
    //    config.setCodec(StringCodec.INSTANCE);
    //    ClusterServersConfig clusterServersConfig = config.useClusterServers().addNodeAddress(clusterNodes.toArray(new String[clusterNodes.size()]));
    //    // 设置密码
    //    clusterServersConfig.setPassword(redisConfigProperties.getPassword());
    //    // redis连接心跳检测，防止一段时间过后，与redis的链接断开
    //    clusterServersConfig.setPingConnectionInterval(32000);
    //    return Redisson.create(config);
    //}

}



