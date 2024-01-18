package top.austin.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.austin.constant.enums.ResponseEnum;
import top.austin.exception.BizException;
import top.austin.exception.api.ApiResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author Linbizhao
 * @description: 全局异常处理
 * @since 2023/12/29 13:28
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ApiResponse<Object> handleBizException(HttpServletRequest request, BizException e) {
        String errorMsg = "requestURI:" + request.getRequestURI() + ",errorCode:" + e.getErrorCode() + ",errorMsg:" + e.getErrorMsg();
        log.error(errorMsg, e);
        return ApiResponse.fail(e.getMessage(), e.getErrorCode());
    }

    /**
     * 处理接口参数数据格式错误异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResponse<Object> handleParameterNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        StringBuilder msgBuilder = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(error -> msgBuilder.append(error.getDefaultMessage()).append(";"));
        String errorMsg = Optional.of(msgBuilder.toString()).filter(StringUtils::isNotBlank).orElse("");
        log.error(errorMsg + ",requestURI:" + request.getRequestURI(), e);
        return ApiResponse.fail(ResponseEnum.PARAMETER_ERROR.getErrorMsg(), ResponseEnum.PARAMETER_ERROR.getErrorCode());
    }

    /**
     * 处理其余异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse<Object> handleException(HttpServletRequest request, Exception e) {
        log.error("internal server error, requestURI:" + request.getRequestURI(), e);
        return ApiResponse.fail(ResponseEnum.INTERNAL_SERVER_ERROR.getErrorMsg(), ResponseEnum.INTERNAL_SERVER_ERROR.getErrorCode());
    }

}
