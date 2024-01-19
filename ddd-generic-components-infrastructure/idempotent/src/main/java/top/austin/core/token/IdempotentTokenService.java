package top.austin.core.token;

import top.austin.core.interfaces.IdempotentExecuteHandler;

/**
 * @Desc: Token方式幂等实现接口
 * @author: Linbizhao
 * @since: 2024/1/19 1:18
 */
public interface IdempotentTokenService extends IdempotentExecuteHandler {

    /**
     * 创建幂等验证Token
     *
     * @return token
     */
    String createToken();
}
