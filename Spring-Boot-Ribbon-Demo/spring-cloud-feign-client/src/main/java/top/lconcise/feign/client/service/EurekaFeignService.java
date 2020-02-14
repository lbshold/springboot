package top.lconcise.feign.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by liusj 2020/2/10
 */
@FeignClient(value = "spring-cloud-ribbon-server")
public interface EurekaFeignService {

    @GetMapping("/users/hello")
    String hello();
}
