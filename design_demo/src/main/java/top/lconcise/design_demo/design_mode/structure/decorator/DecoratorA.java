package top.lconcise.design_demo.design_mode.structure.decorator;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class DecoratorA extends BaseDecorator {

    public DecoratorA(IDecorator decorator) {
        super(decorator);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("增强功能A");
    }
}
