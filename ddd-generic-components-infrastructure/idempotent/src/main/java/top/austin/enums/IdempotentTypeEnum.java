package top.austin.enums;

/**
 * 幂等验证类型枚举
 *
 * @author: Linbizhao
 * @since: 2024/1/19 0:55
 */
public enum IdempotentTypeEnum {

    /**
     * 基于Token方式验证
     */
    TOKEN,

    /**
     * 基于方法参数方式验证
     */
    PARAM,

    /**
     * 基于Spel表达式方式验证
     */
    SPEL
}
