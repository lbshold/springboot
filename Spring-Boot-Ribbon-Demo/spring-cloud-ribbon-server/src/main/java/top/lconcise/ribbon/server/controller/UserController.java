package top.lconcise.ribbon.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lconcise.ribbon.server.domain.User;
import top.lconcise.ribbon.server.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liusj on 2020/1/20
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id, HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        User user = userService.getUserById(id);
        user.setRemark(url);
        return user;
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        LOGGER.info(request.getRequestURL().toString());

        return "Hello Spring-Cloud-Feign-Client";
    }
}
