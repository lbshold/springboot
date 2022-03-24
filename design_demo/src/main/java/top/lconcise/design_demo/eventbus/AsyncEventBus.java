package top.lconcise.design_demo.eventbus;

import java.util.concurrent.Executor;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
