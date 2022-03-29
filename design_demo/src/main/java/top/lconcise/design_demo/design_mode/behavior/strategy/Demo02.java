package top.lconcise.design_demo.design_mode.behavior.strategy;

/**
 * @author: liusj
 * @date: 2022/3/28
 * <p>
 * 非运行时动态确定，在代码中指定使用哪种策略
 */
public class Demo02 {

    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyA();
        UserCache userCache = new UserCache(strategy);
        // ...
    }
}
