package top.lconcise.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by liusj on 2019/7/11
 */
@Configuration
@Import({MyImportBeanDefinitionRegistrar.class})
public class WebConfig8 {
}
