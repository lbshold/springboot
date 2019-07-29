package top.lconcise.security.smscode;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by liusj on 2019/7/29
 */
@Data
public class SmsCode {

    private String code;
    private LocalDateTime expireTime;

    public SmsCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
