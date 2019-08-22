package top.lconcise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lconcise.service.HelloService;

/**
 * Created by liusj on 2019/8/22
 */
@RestController
public class HelloController {

    @Value("${test_name}")
    private String testName;

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return testName;
    }

    @GetMapping("/")
    public String getTestName() {
        return helloService.getTestName();
    }
}
