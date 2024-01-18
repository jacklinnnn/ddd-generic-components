package top.austin.exception;

import lombok.Getter;
import lombok.Setter;
import top.austin.constant.enums.ResponseEnum;

import java.io.Serializable;

/**
 * @author Linbizhao
 * @description: 自定义业务异常
 * @since 2023/12/29 13:09
 */
@Getter
@Setter
public class BizException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 4316294109441961893L;

    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 构造函数
     *
     * @param response 自定义业务错误码枚举
     */
    public BizException(ResponseEnum response) {
        super(response.getErrorMsg());
        this.errorCode = response.getErrorCode();
        this.errorMsg = response.getErrorMsg();
    }

    public BizException(ResponseEnum response, String errorMsg) {
        super(errorMsg);
        this.errorCode = response.getErrorCode();
        this.errorMsg = errorMsg;
    }

    public BizException(ResponseEnum response, Throwable cause) {
        super(response.getErrorMsg(), cause);
        this.errorCode = response.getErrorCode();
        this.errorMsg = response.getErrorMsg();
    }

    public BizException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
