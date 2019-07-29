package top.lconcise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusj on 2019/7/24
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringSecurity!";
    }
}
