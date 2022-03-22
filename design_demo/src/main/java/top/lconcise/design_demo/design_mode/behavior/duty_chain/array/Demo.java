package top.lconcise.design_demo.design_mode.behavior.duty_chain.array;

/**
 * @author: liusj
 * @date: 2022/3/21
 */
public class Demo {

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());

        handlerChain.handle();
    }
}
