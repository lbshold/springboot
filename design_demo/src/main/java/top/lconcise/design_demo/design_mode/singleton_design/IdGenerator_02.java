package top.lconcise.design_demo.design_mode.singleton_design;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式。
 *
 * @author: liusj
 * @date: 2022/3/4
 */
public class IdGenerator_02 {

    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator_02 instance;

    private IdGenerator_02() {
    }

    public static synchronized IdGenerator_02 getInstance() {
        if (instance == null) {
            instance = new IdGenerator_02();
        }
        return instance;
    }

    public Long getId() {
        return id.getAndIncrement();
    }
}
