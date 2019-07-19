package top.lconcise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liusj on 2019/7/19
 */
@Controller
public class DemoController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    @CrossOrigin(value = "*")
    public String hello() {
        return "hello";
    }
}
