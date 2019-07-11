package top.lconcise.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.lconcise.demo.domain.Hello;

/**
 * Created by liusj on 2019/7/11
 */
@Configuration
@Import({Hello.class})
public class WebConfig6 {
}
