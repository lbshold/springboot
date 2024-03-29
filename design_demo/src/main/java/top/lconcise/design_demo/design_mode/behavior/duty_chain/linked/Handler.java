package top.lconcise.design_demo.design_mode.behavior.duty_chain.linked;

/**
 * @author: liusj
 * @date: 2022/3/21
 */
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}
