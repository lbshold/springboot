package top.lconcise.design_demo.alert.improved_code;

import top.lconcise.design_demo.alert.original_code.AlertRule;
import top.lconcise.design_demo.alert.original_code.Notification;
import top.lconcise.design_demo.alert.original_code.NotificationEmergencyLevel;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule alertRule, Notification notification) {
        super(alertRule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > alertRule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SERVER, "...");
        }
    }
}
