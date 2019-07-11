package top.lconcise.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liusj on 2019/7/11
 */
@Configuration
public class WebConfig9 {

    @Bean
    public Demo5FactoryBean demo5FactoryBean() {
        return new Demo5FactoryBean();
    }
}
