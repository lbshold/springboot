package top.lconcise.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.lconcise.demo.domain.User;

/**
 * Created by liusj on 2019/7/11
 * <p>
 * 多扫描策略配置.
 */
@Configuration
//@ComponentScan("top.lconcise.demo")
@ComponentScan("top.lconcise.demo.Service")
@ComponentScan("top.lconcise.demo.controller")
public class WebConfig2 {

    //    @Bean("myUser")
    public User user() {
        return new User("张小龙", 18);
    }
}
