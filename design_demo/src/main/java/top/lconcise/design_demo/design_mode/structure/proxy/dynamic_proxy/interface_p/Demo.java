package top.lconcise.design_demo.design_mode.structure.proxy.dynamic_proxy.interface_p;

import java.lang.reflect.Proxy;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class Demo {

    public static void main(String[] args) {
        IAccount account = new AccountImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(account);

        IAccount proxyInstance = (IAccount) Proxy.newProxyInstance(IAccount.class.getClassLoader(), new Class[]{IAccount.class}, dynamicProxy);
        proxyInstance.queryAccount();
        proxyInstance.updateAccount();
    }
}
