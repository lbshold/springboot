package top.lconcise.design_demo.design_mode.duty_chain;

/**
 * @author: liusj
 * @date: 2022/3/21
 */
public class Demo {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());

        chain.handle();
    }
}
