package top.lconcise.design_demo.eventbus;

/**
 * @author: liusj
 * @date: 2022/5/20
 */
public class DemoObserver02 {

    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println("DemoObserver02" + "给注册用户" + userId + "发放优惠券");
    }

    @Subscribe
    public void handleRegSuccess(DemoEntity name) {
        System.out.println("DemoObserver02" + "给注册用户" + name + "发放优惠券"+ "DemoEntity");
    }
}
