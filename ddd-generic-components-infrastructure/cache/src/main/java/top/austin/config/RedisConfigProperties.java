package top.austin.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Redis缓存配置
 *
 * @author: Linbizhao
 * @since: 2024/1/15 21:16
 */
@Data
@Component
@ConfigurationProperties(prefix = RedisConfigProperties.PREFIX)
public class RedisConfigProperties {

    public static final String PREFIX = "spring.redis";

    /**
     * 端口
     */
    private String port;

    /**
     * host，默认为：127.0.0.1
     */
    private String host;

    /**
     * 密码，默认为空
     */
    private String password;

    /**
     * 数据库，默认为第0库
     */
    private String database;

    /**
     * Redis集群
     */
    private Cluster cluster;

    /**
     * Redis单机
     */
    private Single single;


    /**
     * 默认超时时间，默认6个小时
     */
    private Long defaultValueTimeout = 21600L;

    /**
     * 时间单位: 秒
     */
    private TimeUnit valueTimeUnit = TimeUnit.SECONDS;

    @Data
    @AllArgsConstructor
    public static class Cluster {

        private List<String> nodeAddress;
    }

    @Data
    @AllArgsConstructor
    public static class Single {

        private String address;

        private Integer database;
    }

}
