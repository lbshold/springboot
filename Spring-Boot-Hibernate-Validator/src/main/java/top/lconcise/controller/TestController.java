package top.lconcise.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lconcise.domain.User;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Created by liusj on 2019/8/13
 */
@RestController
@Validated
public class TestController {

    @GetMapping("/hello")
    public String hello(@NotBlank(message = "{required}") String name,
                        @Email(message = "{invalid}") String email) {
        return "Hello World";
    }

    @GetMapping("/hello2")
    public String hello2(@Valid User user) {
        return "Hello World2";
    }
}
