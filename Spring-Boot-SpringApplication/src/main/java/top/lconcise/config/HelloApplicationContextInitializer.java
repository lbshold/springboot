package top.lconcise.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by liusj on 2019/7/12
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ConfigurableApplicationContext.id -" + configurableApplicationContext.getId());
    }
}
