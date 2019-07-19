package top.lconcise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lconcise.exception.UserNotException;

/**
 * Created by liusj on 2019/7/18
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("user/{id:\\d+}")
    public void get(@PathVariable String id) {
        throw new RuntimeException("user not exist");
    }

    @GetMapping("user2/{id:\\d+}")
    public void get2(@PathVariable String id) {
        throw new UserNotException(id);
    }
}
