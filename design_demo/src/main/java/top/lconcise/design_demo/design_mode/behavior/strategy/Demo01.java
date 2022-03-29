package top.lconcise.design_demo.design_mode.behavior.strategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author: liusj
 * @date: 2022/3/28
 * 运行时动态确定，根据配置文件的配置决定使用哪种策略
 */
public class Demo01 {

    public static void main(String[] args) throws FileNotFoundException {
        Strategy strategy = null;
        Properties props = new Properties();
        props.load(new FileInputStream("./config.properties"));
        String type = props.getProperty("eviction_type");
        strategy = StrategyFactory.getStrategy(type);
        UserCache userCache = new UserCache(strategy);

        // ...
    }
}
