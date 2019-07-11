package top.lconcise.demo.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import top.lconcise.demo.domain.Demo4;

/**
 * Created by liusj on 2019/7/11
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        final String beanName = "demo4";
        boolean contain = beanDefinitionRegistry.containsBeanDefinition(beanName);
        if (!contain) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Demo4.class);
            beanDefinitionRegistry.registerBeanDefinition(beanName, rootBeanDefinition);
        }
    }
}
