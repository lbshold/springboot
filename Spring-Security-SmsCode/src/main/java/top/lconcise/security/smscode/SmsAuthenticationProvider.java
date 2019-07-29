package top.lconcise.security.smscode;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by liusj on 2019/7/29
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {


    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
