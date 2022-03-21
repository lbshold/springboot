package top.lconcise.design_demo.design_mode.duty_chain;

/**
 * @author: liusj
 * @date: 2022/3/21
 */
public class HandlerA extends Handler {

    @Override
    protected void handle() {
        boolean handled = false;
        // ...
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
