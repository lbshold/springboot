package top.lconcise.security.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by liusj on 2019/7/26
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 2672899097153524723L;

    public ValidateCodeException(String explanation) {
        super(explanation);
    }
}
