package top.lconcise.design_demo.design_mode.creaction.singleton_design;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类。
 *
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
        DateFormat format = new SimpleDateFormat();
        return IdGenerator_04_inner.instance;
    }

    public Long getId() {
        return id.getAndIncrement();
    }
}
