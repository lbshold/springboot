package top.lconcise.design_demo.alert.improved_code;

/**
 * @author: liusj
 * @date: 2022/3/14
 */
public class Demo {

    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ...省略设置apiStatInfo数据值的代码
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
