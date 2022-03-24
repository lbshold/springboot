package top.lconcise.design_demo.alert.improved_code;

import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public class TelephoneMsgSender implements MsgSender {

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        // ...
    }
}
