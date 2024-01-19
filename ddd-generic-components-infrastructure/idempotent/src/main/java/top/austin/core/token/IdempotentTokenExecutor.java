package top.austin.core.token;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import top.austin.core.IdempotentParamWrapper;
import top.austin.core.abstracts.AbstractIdempotentExecuteHandler;

/**
 * @Desc: 基于Token验证请求的幂等性，通常应用与RestAPI方法
 * @author: Linbizhao
 * @since: 2024/1/19 1:21
 */
@RequiredArgsConstructor
public class IdempotentTokenExecutor extends AbstractIdempotentExecuteHandler implements IdempotentTokenService {

    @Override
    protected IdempotentParamWrapper buildParamWrapper(ProceedingJoinPoint joinPoint) {
        return null;
    }

    @Override
    public void handler(IdempotentParamWrapper wrapper) {

    }

    @Override
    public String createToken() {
        return null;
    }
}
