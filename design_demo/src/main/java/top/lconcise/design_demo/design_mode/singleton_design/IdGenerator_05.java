package top.lconcise.design_demo.design_mode.singleton_design;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举。
 *
 * @author: liusj
 * @date: 2022/3/4
 */
public enum IdGenerator_05 {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public Long getId() {
        return id.getAndIncrement();
    }
}
