package top.austin.core.interfaces;

import org.aspectj.lang.ProceedingJoinPoint;
import top.austin.annotation.Idempotent;
import top.austin.core.IdempotentParamWrapper;

/**
 * 幂等执行处理器
 *
 * @author: Linbizhao
 * @since: 2024/1/19 1:03
 */
public interface IdempotentExecuteHandler {

    /**
     * 幂等处理逻辑
     *
     * @param wrapper
     */
    void handler(IdempotentParamWrapper wrapper);

    /**
     * 执行幂等处理逻辑
     *
     * @param joinPoint
     * @param idempotent
     */
    void execute(ProceedingJoinPoint joinPoint, Idempotent idempotent);

    /**
     * 异常流程处理
     */
    default void exceptionProcess() {

    }

    /**
     * 后置处理
     */
    default void postProcess() {

    }
}
