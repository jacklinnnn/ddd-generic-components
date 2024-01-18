package top.austin.exception;

import lombok.Data;

/**
 * @author Linbizhao
 * @description: 消息异常
 * @since 2023/11/23 10:29
 */
@Data
public class MessageException extends RuntimeException {

    private static final long serialVersionUID = 4630507694090636342L;

    private String code;

    private String message;

    public MessageException() {
        super();
    }

    public MessageException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
