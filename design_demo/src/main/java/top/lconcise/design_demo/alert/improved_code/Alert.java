package top.lconcise.design_demo.alert.improved_code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
public class Alert {

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler alertHandler : alertHandlers) {
            alertHandler.check(apiStatInfo);
        }
    }
}
