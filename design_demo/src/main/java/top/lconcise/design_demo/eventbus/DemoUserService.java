package top.lconcise.design_demo.eventbus;

import java.util.List;

/**
 * @author: liusj
 * @date: 2022/5/20
 */
public class DemoUserService {

    private EventBus eventBus;

    public DemoUserService() {
        eventBus = new EventBus();
    }

    /**
     * 添加观察者.
     *
     * @param observers
     */
    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    /**
     * 注册用户，触发动作。
     * @param phone
     * @param password
     */
    public Long register(String phone, String password) {
        // 注册用户。。。
        Long userId = 1L; // 注册返回用户id

        eventBus.post(userId);

        return userId;
    }
}
