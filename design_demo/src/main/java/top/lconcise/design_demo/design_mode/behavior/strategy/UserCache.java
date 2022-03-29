package top.lconcise.design_demo.design_mode.behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2022/3/28
 * <p>
 * // 策略接口：EvictionStrategy
 * // 策略类：LruEvictionStrategy、FifoEvictionStrategy、LfuEvictionStrategy...
 * // 策略工厂：EvictionStrategyFactory
 */
public class UserCache {
    private Map<String, User> cacheData = new HashMap<>();
    private Strategy strategy;

    public UserCache(Strategy strategy) {
        this.strategy = strategy;
    }

}
