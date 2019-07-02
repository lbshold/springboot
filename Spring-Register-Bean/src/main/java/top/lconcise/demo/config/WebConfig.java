package lconcise.top.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * Created by liusj on 2019/7/1
 */
@Configuration
@ComponentScan(value = "lconcise.top.demo",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Repository.class})})
public class WebConfig {

//    @Bean("myUser")
//    public User user() {
//        return new User("张小龙", "123456");
//    }
}
