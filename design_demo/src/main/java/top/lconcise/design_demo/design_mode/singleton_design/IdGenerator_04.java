package top.lconcise.design_demo.design_mode.singleton_design;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: liusj
 * @date: 2022/3/4
 */
public class IdGenerator_04 {

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator_04() {
    }

    private static class IdGenerator_04_inner {
        private static final IdGenerator_04 instance = new IdGenerator_04();
    }

    public static IdGenerator_04 getInstance() {
        return IdGenerator_04_inner.instance;
    }

    public Long getId() {
        return id.getAndIncrement();
    }
}
