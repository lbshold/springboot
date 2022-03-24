package top.lconcise.design_demo.alert.improved_code;

import top.lconcise.design_demo.alert.original_code.NotificationEmergencyLevel;

import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public class OriginalNotification {
    private List emailAddresses;
    private List telephones;
    private List wechatIds;

    public OriginalNotification() {
    }

    public void setEmailAddress(List emailAddress) {
        this.emailAddresses = emailAddress;
    }

    public void setTelephones(List telephones) {
        this.telephones = telephones;
    }

    public void setWechatIds(List wechatIds) {
        this.wechatIds = wechatIds;
    }

    public void notify(NotificationEmergencyLevel level, String message) {
        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //...发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //...发邮件
        }
    }
}
