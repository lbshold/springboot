package top.lconcise.demo.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata;
import org.springframework.context.annotation.*;
import top.lconcise.demo.domain.User;

/**
 * Created by liusj on 2019/7/11
 * <p>
 */
@Configuration
@ComponentScan("top.lconcise.demo")
public class WebConfig {

    @Bean("myUser")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    public User user() {
        System.out.println("往ioc 容器中注册 user bean ");
        return new User("张小龙", 18);
    }
}
