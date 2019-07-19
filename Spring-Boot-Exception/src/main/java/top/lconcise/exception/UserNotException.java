package top.lconcise.exception;

import lombok.Data;

/**
 * Created by liusj on 2019/7/18
 */
@Data
public class UserNotException extends RuntimeException {

    private String id;

    public UserNotException(String id) {
        super("user not exist");
        this.id = id;
    }
}
