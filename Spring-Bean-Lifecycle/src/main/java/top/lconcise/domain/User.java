package top.lconcise.domain;

import lombok.extern.java.Log;

/**
 * Created by liusj on 2019/7/2
 */
@Log
public class User {

    public User() {
        log.info("调用无参构造创建User");
    }

    public void init() {
        log.info("初始化 User");
    }

    public void destroy() {
        log.info("销毁 User");
    }
}
