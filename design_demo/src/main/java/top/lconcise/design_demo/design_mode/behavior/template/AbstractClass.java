package top.lconcise.design_demo.design_mode.behavior.template;

/**
 * @author: liusj
 * @date: 2022/3/23
 */
public abstract class AbstractClass {

    public final void templatedMethod() {
        // ...
        method01();
        // ...
        method02();
    }

    public abstract void method01();

    public abstract void method02();
}
