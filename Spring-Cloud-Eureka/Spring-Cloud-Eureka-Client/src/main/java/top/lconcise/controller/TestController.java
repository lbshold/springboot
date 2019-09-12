package top.lconcise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusj on 2019/9/11
 */
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/info")
    public String info() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String service : client.getServices()) {
            stringBuilder.append(service + " ");
        }
        return stringBuilder.toString();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
