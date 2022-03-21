package top.lconcise.design_demo.design_mode.duty_chain;

/**
 * @author: liusj
 * @date: 2022/3/21
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);

        if(head == null){
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle(){
        if(head!=null){
            head.handle();
        }
    }
}
