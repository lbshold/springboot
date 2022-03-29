package top.lconcise.design_demo.design_mode.behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public class StrategyFactory {
    private static final Map<String, Strategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put("A", new ConcreteStrategyA());
        strategyMap.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (type == null || type.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategyMap.get(type);
    }
}
