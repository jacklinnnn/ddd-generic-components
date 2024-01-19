package top.austin.exception;

import lombok.Data;

/**
 * 消息异常
 *
 * @author: Linbizhao
 * @since: 2024/1/19 0:54
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
