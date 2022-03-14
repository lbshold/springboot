package top.lconcise.design_demo.design_mode.singleton_design;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检测.
 *
 * @author: liusj
 * @date: 2022/3/4
 */
public class IdGenerator_03 {

    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator_03 instance;

    private IdGenerator_03() {
    }

    public static IdGenerator_03 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator_03.class) {
                if (instance == null) {
                    instance = new IdGenerator_03();
                }
            }
        }
        return instance;
    }

    public Long getId() {
        return id.getAndIncrement();
    }
}
