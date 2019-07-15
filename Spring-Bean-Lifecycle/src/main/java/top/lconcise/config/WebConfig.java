package top.lconcise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.lconcise.domain.Bird;
import top.lconcise.domain.Sweets;
import top.lconcise.domain.User;

/**
 * Created by liusj on 2019/7/2
 */
@Configuration
public class WebConfig {

    @Bean
    public Sweets sweets() {
        return new Sweets();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public User user() {
        return new User();
    }

    @Bean
    public Bird bird() {
        return new Bird();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
