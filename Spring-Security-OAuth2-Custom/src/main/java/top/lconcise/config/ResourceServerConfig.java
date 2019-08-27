package top.lconcise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import top.lconcise.handler.MyAuthenticationFailureHandler;
import top.lconcise.handler.MyAuthenticationSuccessHandler;

/**
 * Created by liusj on 2019/8/26
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单登录
                .loginProcessingUrl("/login") // 处理表单登录 url
                .successHandler(myAuthenticationSuccessHandler)  // 处理登录成功
                .failureHandler(myAuthenticationFailureHandler)  // 处理登录失败
                .and()
                .authorizeRequests()   // 授权配置
                .anyRequest()          // 所有请求
                .authenticated()       // 都需要认证
                .and()
                .csrf().disable();
    }
}
