package top.lconcise.design_demo.alert.improved_code;

import top.lconcise.design_demo.alert.original_code.AlertRule;
import top.lconcise.design_demo.alert.original_code.Notification;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    private void initializeBean() {
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
    }

    public Alert getAlert() {
        return alert;
    }

    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        initializeBean();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }
}
