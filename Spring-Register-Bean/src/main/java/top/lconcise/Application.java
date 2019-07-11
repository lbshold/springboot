package top.lconcise;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.lconcise.demo.config.WebConfig;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        // 返回 IOC 容器，使用注解配置，传入配置类
//        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
//        String[] namesForType = context.getBeanNamesForType(User.class);
//        Arrays.stream(namesForType).forEach(System.out::println);


        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        String[] beanNamesForType = context.getBeanDefinitionNames();
        Arrays.stream(beanNamesForType).forEach(System.out::println);

//        System.out.println("容器创建完毕");
//        User bean = context.getBean(User.class);
//        System.out.println(bean);

//        Object demo5FactoryBean = context.getBean("demo5FactoryBean");
//        System.out.println(demo5FactoryBean.getClass());
//        Object demo5FactoryBean2 = context.getBean("&demo5FactoryBean");
//        System.out.println(demo5FactoryBean2.getClass());

//        Object myUser = context.getBean("myUser");
//        Object myUser2 = context.getBean("myUser");
//
//        System.out.println(myUser == myUser2);、

//        ConfigurableApplicationContext context1 = new SpringApplicationBuilder(Application.class)
//                .web(WebApplicationType.NONE)
//                .profiles("java8")
//                .run(args);
//        SweetService bean = context1.getBean(SweetService.class);
//        bean.eat();
    }

}
