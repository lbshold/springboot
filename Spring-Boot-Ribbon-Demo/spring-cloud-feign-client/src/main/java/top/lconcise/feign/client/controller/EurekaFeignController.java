package top.lconcise.feign.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lconcise.feign.client.service.EurekaFeignService;

/**
 * Created by liusj 2020/2/10
 */
@RestController
public class EurekaFeignController {

    @Autowired
    private EurekaFeignService eurekaFeignService;

    @GetMapping("/hello")
    public String hello() {
        return eurekaFeignService.hello();
    }
}
