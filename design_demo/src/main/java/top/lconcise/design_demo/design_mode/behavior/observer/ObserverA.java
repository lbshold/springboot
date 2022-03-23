package top.lconcise.design_demo.design_mode.behavior.observer;

/**
 * @author: liusj
 * @date: 2022/3/23
 */
public class ObserverA implements IObserver {

    @Override
    public void update(Message message) {
        System.out.println("ObserverA 接收到消息");
    }
}
