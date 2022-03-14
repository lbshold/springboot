package top.lconcise.design_demo.alert.improved_code;

import top.lconcise.design_demo.alert.original_code.AlertRule;
import top.lconcise.design_demo.alert.original_code.Notification;
import top.lconcise.design_demo.alert.original_code.NotificationEmergencyLevel;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestConut() / apiStatInfo.getDurationSeconds();
        if (tps > alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
