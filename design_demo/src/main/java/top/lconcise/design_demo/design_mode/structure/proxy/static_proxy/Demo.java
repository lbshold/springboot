package top.lconcise.design_demo.design_mode.structure.proxy.static_proxy;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class Demo {

    public static void main(String[] args) {
        IAccount account = new AccountImpl();
        AccountProxy accountProxy = new AccountProxy(account);

        accountProxy.queryAccount();
        accountProxy.updateAccount();
    }
}
