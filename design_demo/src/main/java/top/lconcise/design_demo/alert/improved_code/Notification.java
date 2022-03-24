package top.lconcise.design_demo.alert.improved_code;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
