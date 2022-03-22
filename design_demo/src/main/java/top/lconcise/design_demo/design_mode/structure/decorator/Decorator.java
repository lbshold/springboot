package top.lconcise.design_demo.design_mode.structure.decorator;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class Decorator implements IDecorator {

    @Override
    public void decorate() {
        System.out.println("基础功能");
    }
}
