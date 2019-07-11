package top.lconcise.demo.config;

import org.springframework.beans.factory.FactoryBean;
import top.lconcise.demo.domain.Demo5;

/**
 * Created by liusj on 2019/7/11
 */
public class Demo5FactoryBean implements FactoryBean<Demo5> {

    @Override
    public Demo5 getObject() throws Exception {
        return new Demo5();
    }

    @Override
    public Class<?> getObjectType() {
        return Demo5.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
