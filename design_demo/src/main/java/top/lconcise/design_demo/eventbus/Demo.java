package top.lconcise.design_demo.eventbus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/5/20
 */
public class Demo {

    public static void main(String[] args) {
        DemoUserService userService = new DemoUserService();

        DemoObserver01 observer01 = new DemoObserver01();
        DemoObserver02 observer02 = new DemoObserver02();
        List<Object> observers = new ArrayList<>();
        observers.add(observer01);
        observers.add(observer02);
        // 注册观察者
        userService.setRegObservers(observers);
        // 注册用户并执行相应的操作
        userService.register("手机号", "姓名");
    }

}
