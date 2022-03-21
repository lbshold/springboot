package top.lconcise.design_demo.design_mode.duty_chain;

/**
 * @author: liusj
 * @date: 2022/3/21
 */
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handle();
}
