package top.lconcise.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import top.lconcise.demo.domain.User;

/**
 * Created by liusj on 2019/7/11
 */
@Configuration
public class WebConfig5 {

    @Bean
    @Conditional(MyCondition.class)
    public User user() {
        return new User("张小龙", 19);
    }
}
