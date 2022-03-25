package top.lconcise.design_demo.design_mode.creaction.builder;

/**
 * @author: liusj
 * @date: 2022/3/23
 */
public class Demo {

    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbConnectionPool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(12)
                .build();
    }
}
