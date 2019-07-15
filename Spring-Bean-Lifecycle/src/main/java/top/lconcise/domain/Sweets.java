package top.lconcise.domain;

import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by liusj on 2019/7/2
 */
@Log
public class Sweets {

    public Sweets() {
        log.info("调用无参构造创建Sweets");
    }

    @PostConstruct
    public void init() {
        log.info("初始化 Sweets");
    }

    @PreDestroy
    public void destroy() {
        log.info("销毁 Sweets");
    }
}
