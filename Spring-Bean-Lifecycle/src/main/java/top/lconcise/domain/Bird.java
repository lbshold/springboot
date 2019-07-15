package top.lconcise.domain;

import lombok.extern.java.Log;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by liusj on 2019/7/2
 */
@Log
public class Bird implements InitializingBean, DisposableBean {

    public Bird() {
        log.info("调用无参构造创建Bird");
    }

    @Override
    public void destroy() throws Exception {
        log.info("销毁 Bird");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("初始化 Bird");
    }
}
