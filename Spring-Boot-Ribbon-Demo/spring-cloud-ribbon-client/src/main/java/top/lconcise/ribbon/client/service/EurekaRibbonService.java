package top.lconcise.ribbon.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.lconcise.ribbon.client.domain.User;

/**
 * Created by liusj on 2020/1/21
 */
@Service
public class EurekaRibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public User findByUserId(Long id){
       return restTemplate.getForObject("http://spring-cloud-ribbon-server/users/"+id,User.class);
    }
}
