package top.lconcise.design_demo.alert.improved_code;

import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public class EmailMsgSender implements MsgSender{

    private List<String> emails;

    public EmailMsgSender(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void send(String message) {
        // ...
    }
}
