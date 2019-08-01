package top.lconcise.security.smscode;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by liusj on 2019/7/29
 */
public class SmsAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 8151829567809593110L;

    private final Object principal;

    public SmsAuthenticationToken(String mobile) {
        super(null);
        this.principal = mobile;
        super.setAuthenticated(false);
    }

    public SmsAuthenticationToken(Collection<? extends GrantedAuthority> authorities, Object principal) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

}
