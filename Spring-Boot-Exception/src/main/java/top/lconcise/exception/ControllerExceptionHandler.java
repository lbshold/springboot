package top.lconcise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liusj on 2019/7/18
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerUserNotExistsException(UserNotException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", e.getId());
        map.put("message", e.getMessage());
        return map;
    }
}
