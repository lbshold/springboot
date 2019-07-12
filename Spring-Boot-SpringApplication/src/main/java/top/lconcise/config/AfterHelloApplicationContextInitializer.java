package top.lconcise.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by liusj on 2019/7/12
 */
public class AfterHelloApplicationContextInitializer implements ApplicationContextInitializer ,Ordered{
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("AfterConfigurableApplicationContext.id -" + configurableApplicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
