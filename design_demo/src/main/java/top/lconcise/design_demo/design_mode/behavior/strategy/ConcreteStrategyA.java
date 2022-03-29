package top.lconcise.design_demo.design_mode.behavior.strategy;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法A");
    }
}
