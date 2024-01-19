package top.austin.enums;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * 幂等MQ消费阶段状态枚举
 *
 * @author: Linbizhao
 * @since: 2024/1/19 0:59
 */
@RequiredArgsConstructor
public enum IdempotentMQConsumerStage {

    CONSUMING("0"),


    CONSUMED("1");

    private final String code;

    /**
     * 如果消费状态等于消费中，返回失败
     *
     * @param consumeStatus 消费状态
     * @return 是否消费失败
     */
    public static boolean isError(String consumeStatus) {
        return Objects.equals(CONSUMING.code, consumeStatus);
    }

}
