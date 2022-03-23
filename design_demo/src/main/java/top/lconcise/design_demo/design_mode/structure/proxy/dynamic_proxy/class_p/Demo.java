package top.lconcise.design_demo.design_mode.structure.proxy.dynamic_proxy.class_p;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class Demo {

    public static void main(String[] args) {
        Account account = new Account();
        MyInterceptor interceptor = new MyInterceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Account.class);
        enhancer.setCallback(interceptor);
        Account proxyInstance = (Account)enhancer.create();

        proxyInstance.queryAccount();
        proxyInstance.updateAccount();
    }
}
