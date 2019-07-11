package top.lconcise.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import top.lconcise.demo.domain.User;

/**
 * Created by liusj on 2019/7/11
 * 指定扫描策略.
 */
@Configuration
@ComponentScan(value = "top.lconcise.demo",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Repository.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = User.class)})
public class WebConfig3 {
}
