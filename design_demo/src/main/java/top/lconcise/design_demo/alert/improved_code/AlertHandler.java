package top.lconcise.design_demo.alert.improved_code;

import top.lconcise.design_demo.alert.original_code.AlertRule;
import top.lconcise.design_demo.alert.original_code.Notification;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
public abstract class AlertHandler {
    protected AlertRule alertRule;
    protected Notification notification;

    public AlertHandler(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
