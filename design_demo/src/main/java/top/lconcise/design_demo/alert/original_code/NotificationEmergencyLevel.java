package top.lconcise.design_demo.alert.original_code;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
public enum NotificationEmergencyLevel {

    SEVERE("001", "严重"),
    URGENCY("002", "紧急"),
    NORMAL("003", "普通"),
    TRIVIAL("004", "无关紧要");

    private String code;
    private String desc;

    NotificationEmergencyLevel(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
