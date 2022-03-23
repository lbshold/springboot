package top.lconcise.design_demo.design_mode.structure.proxy.dynamic_proxy.interface_p;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class AccountImpl implements IAccount {

    @Override
    public void queryAccount() {
        System.out.println("查询账户。。。");
    }

    @Override
    public void updateAccount() {
        System.out.println("修改账户。。。");
    }
}
