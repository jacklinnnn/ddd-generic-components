package top.austin.compoment;

import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc: redis缓存配置
 * @Author: Linbizhao
 * @Since: 2024/1/15 21:16
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfigProperties implements Serializable {

    private static final long serialVersionUID = 8815222005846355408L;

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
