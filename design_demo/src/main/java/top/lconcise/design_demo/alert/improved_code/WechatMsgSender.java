package top.lconcise.design_demo.alert.improved_code;

import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public class WechatMsgSender implements MsgSender {

    private List<String> wechats;

    public WechatMsgSender(List<String> wechats) {
        this.wechats = wechats;
    }

    @Override
    public void send(String message) {
        // ...
    }
}
