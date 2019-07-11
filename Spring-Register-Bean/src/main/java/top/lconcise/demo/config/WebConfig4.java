package top.lconcise.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by liusj on 2019/7/11
 */
@Configuration
@ComponentScan(value = "top.lconcise.demo",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)})
public class WebConfig4 {
}
