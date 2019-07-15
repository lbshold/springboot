package top.lconcise;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.lconcise.config.WebConfig;

@Log
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // 返回IOC容器，使用注解配置，传入配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        log.info("== 容器创建完毕 ");
        context.close();
    }
}
