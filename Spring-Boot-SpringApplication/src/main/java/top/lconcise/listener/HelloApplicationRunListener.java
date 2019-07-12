package top.lconcise.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by liusj on 2019/7/12
 */
public class HelloApplicationRunListener implements SpringApplicationRunListener {

    public HelloApplicationRunListener(SpringApplication application, String[] args) {
    }

    @Override
    public void starting() {
        System.out.println("=== HelloApplicationRunListener starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("=== HelloApplicationRunListener environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("=== HelloApplicationRunListener contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("=== HelloApplicationRunListener contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("=== HelloApplicationRunListener started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("=== HelloApplicationRunListener running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("=== HelloApplicationRunListener failed");
    }
}
