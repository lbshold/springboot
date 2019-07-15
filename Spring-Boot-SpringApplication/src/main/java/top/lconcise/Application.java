package top.lconcise;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

//        SpringApplication application = new SpringApplication(Application.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.setAdditionalProfiles("dev");
//        application.run(args);

//        new SpringApplicationBuilder(Application.class)
//                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
//                .profiles("dev")
//                .run(args);

//        SpringApplication application = new SpringApplication(Application.class);
//        application.run(args);

       SpringApplication application = new SpringApplication(ApplicationResource.class);
        application.run(args);

//        new SpringApplicationBuilder(Application.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
}

    @SpringBootApplication
    public static class ApplicationResource {

    }

}
