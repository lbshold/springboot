package top.lconcise.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusj on 2019/8/6
 */
@RestController
public class HelloController2 {
    private static final Logger logger = LoggerFactory.getLogger(HelloController2.class);

    @GetMapping("/hello2")
    public String hello() {
        logger.trace("日志输出2 trace");
        logger.debug("日志输出2 debug");
        logger.info("日志输出2 info");
        logger.warn("日志输出2 warn");
        logger.error("日志输出2 error");

        return "hello";
    }
}
