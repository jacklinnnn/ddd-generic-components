package top.austin.core.abstracts;

import org.aspectj.lang.ProceedingJoinPoint;
import top.austin.annotation.Idempotent;
import top.austin.core.IdempotentParamWrapper;
import top.austin.core.interfaces.IdempotentExecuteHandler;

/**
 * 抽象幂等执行处理器
 *
 * @author: Linbizhao
 * @since: 2024/1/19 1:09
 */
public abstract class AbstractIdempotentExecuteHandler implements IdempotentExecuteHandler {

    /**
     * 构建幂等执行处理器
     * @param joinPoint AOP方法处理
     * @return 幂等参数包装器
     */
    protected abstract IdempotentParamWrapper buildParamWrapper(ProceedingJoinPoint joinPoint);

    /**
     * 执行幂等处理逻辑
     *
     * @param joinPoint AOP方法处理
     * @param idempotent 幂等注解
     */
    @Override
    public void execute(ProceedingJoinPoint joinPoint, Idempotent idempotent) {
        IdempotentParamWrapper idempotentParamWrapper = buildParamWrapper(joinPoint).setIdempotent(idempotent);
        handler(idempotentParamWrapper);
    }
}
