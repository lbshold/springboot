package top.lconcise.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lconcise.domain.User;
import top.lconcise.service.UserService;

import java.util.List;

/**
 * Created by liusj on 2019/7/25
 */
@Log
@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        List<User> list = userService.list();
        log.info("list size " + list.size());
        return String.valueOf(list.size());
    }
}
