package top.lconcise.design_demo.design_mode.singleton_design;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式.
 *
 * @author: liusj
 * @date: 2022/3/4
 */
public class IdGenerator_01 {

    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator_01 idGenerator = new IdGenerator_01();

    private IdGenerator_01() {
    }

    public static IdGenerator_01 getInstance() {
        return idGenerator;
    }

    public Long getId() {
        return id.incrementAndGet();
    }
}
