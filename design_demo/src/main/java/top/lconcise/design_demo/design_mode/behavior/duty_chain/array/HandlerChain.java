package top.lconcise.design_demo.design_mode.behavior.duty_chain.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/21
 */
public class HandlerChain {

    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean handle = handler.handle();
            if (handle) {
                break;
            }
        }
    }
}
