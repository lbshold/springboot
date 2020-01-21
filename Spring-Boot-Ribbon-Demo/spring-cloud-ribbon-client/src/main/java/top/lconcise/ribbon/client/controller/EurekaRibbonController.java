package top.lconcise.ribbon.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.lconcise.ribbon.client.domain.User;
import top.lconcise.ribbon.client.service.EurekaRibbonService;

/**
 * Created by liusj on 2020/1/21
 */
@RestController
public class EurekaRibbonController {

    @Autowired
    private EurekaRibbonService eurekaRibbonService;

    @GetMapping("/{id}")
    public User findByUserId(@PathVariable Long id){
        return eurekaRibbonService.findByUserId(id);
    }
}
