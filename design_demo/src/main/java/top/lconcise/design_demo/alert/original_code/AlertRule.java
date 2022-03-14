package top.lconcise.design_demo.alert.original_code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
public class AlertRule {

    private long maxTps;

    private long maxErrorCount;

    private Map<String, AlertRule> ruleMap = new HashMap<>();

    public AlertRule getMatchedRule(String apiName) {
        return ruleMap.get(apiName);
    }

    public long getMaxTps() {
        return maxTps;
    }

    public long getMaxErrorCount() {
        return maxErrorCount;
    }
}
