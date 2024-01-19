package top.austin.exception.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import top.austin.constant.enums.ResponseEnum;

import java.sql.Timestamp;

/**
 * 统一接口返回格式
 *
 * @author: Linbizhao
 * @since: 2024/1/19 0:54
 */
@Getter
@Setter
public class ApiResponse<T> {

    @ApiModelProperty("成功状态")
    private boolean success;

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("提示信息")
    private String message;

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("时间戳")
    private Timestamp timestamp;

    public ApiResponse(boolean success, T data, Integer code, String message, Timestamp timestamp) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public ApiResponse(boolean success, T data, String message, Integer code) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public static <T> ApiResponse<T> genResponse(boolean success, T data, String message, Integer errorCode) {
        return new ApiResponse<>(success, data, message, errorCode);
    }

    public static <T> ApiResponse<T> success(T data) {
        return genResponse(true, data, ResponseEnum.SUCCESS.getErrorMsg(), ResponseEnum.SUCCESS.getErrorCode());
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return genResponse(true, data, message, ResponseEnum.SUCCESS.getErrorCode());
    }

    public static <T> ApiResponse<T> ok(T data) {
        return genResponse(true, data, ResponseEnum.SUCCESS.getErrorMsg(), ResponseEnum.SUCCESS.getErrorCode());
    }

    public static <T> ApiResponse<T> ok(T data, String message) {
        return genResponse(true, data, message, ResponseEnum.SUCCESS.getErrorCode());
    }

    public static <T> ApiResponse<T> fail(T data, String message, Integer errorCode) {
        return genResponse(false, data, message, errorCode);
    }

    public static <T> ApiResponse<T> fail(String message, Integer errorCode) {
        return genResponse(false, null, message, errorCode);
    }

    public static <T> ApiResponse<T> fail(String message) {
        return genResponse(false, null, message, ResponseEnum.INTERNAL_SERVER_ERROR.getErrorCode());
    }

}
