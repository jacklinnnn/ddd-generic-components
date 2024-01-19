package top.austin.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.aspectj.lang.ProceedingJoinPoint;
import top.austin.annotation.Idempotent;

/**
 * 幂等参数包装
 *
 * @author: Linbizhao
 * @since: 2024/1/19 1:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class IdempotentParamWrapper {

    /**
     * 幂等注解
     */
    private Idempotent idempotent;

    /**
     * AOP切入点
     */
    private ProceedingJoinPoint joinPoint;

    /**
     * 锁标识 {@link top.austin.enums.IdempotentTypeEnum#PARAM}
     */
    private String lockKey;
}
