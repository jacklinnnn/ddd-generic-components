package top.austin.enums;

/**
 * 幂等验证场景枚举
 *
 * @author: Linbizhao
 * @since: 2024/1/19 0:57
 */
public enum IdempotentSceneEnum {

    /**
     * 基于RestAPI场景幂等验证
     */
    RESTAPI,

    /**
     * 基于MQ消息幂等验证
     */
    MQ_MESSAGE,
}
