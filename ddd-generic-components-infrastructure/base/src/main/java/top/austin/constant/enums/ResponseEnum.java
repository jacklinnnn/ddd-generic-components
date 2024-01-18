package top.austin.constant.enums;

/**
 * @author Linbizhao 2023/11/17 18:17
 * @description: 响应结果枚举
 */
public enum ResponseEnum {

    /**
     * 成功
     */
    SUCCESS(0, "成功!"),
    /**
     * 业务处理异常
     */
    BUSINESS_ERROR(-1, "业务处理异常!"),
    /**
     * 服务端内部异常
     */
    INTERNAL_SERVER_ERROR(500, "服务端内部异常!"),
    /**
     * 参数异常
     */
    PARAMETER_ERROR(102, "参数异常!"),
    /**
     * 未找到该资源
     */
    NOT_FOUND(404, "未找到该资源!"),
    /**
     * 服务器正忙，请稍后再试
     */
    SERVER_BUSY(503, "服务器正忙，请稍后再试!");


    private final Integer errorCode;
    private final String errorMsg;

    ResponseEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
