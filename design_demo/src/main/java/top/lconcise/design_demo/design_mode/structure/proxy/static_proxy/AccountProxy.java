package top.lconcise.design_demo.design_mode.structure.proxy.static_proxy;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class AccountProxy implements IAccount {

    private IAccount account;

    public AccountProxy(IAccount account) {
        this.account = account;
    }

    @Override
    public void queryAccount() {
        System.out.println("查询账户预处理。。。");
        account.queryAccount();
        System.out.println("查询账户之后的处理...");
    }

    @Override
    public void updateAccount() {
        System.out.println("修改账户预处理。。。");
        account.updateAccount();
        System.out.println("修改账户之后的处理。。。");
    }
}
