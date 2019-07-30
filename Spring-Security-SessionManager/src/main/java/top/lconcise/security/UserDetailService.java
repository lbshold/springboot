package top.lconcise.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.lconcise.domain.MyUser;

/**
 * Created by liusj on 2019/7/23
 */
@Configuration
@Log
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUser user = new MyUser();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("123456"));

        log.info("password : " + user.getPassword());
        return user;
    }
}
