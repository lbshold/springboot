package top.lconcise.design_demo.design_mode.structure.decorator;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class DecoratorB extends BaseDecorator {

    public DecoratorB(IDecorator decorator) {
        super(decorator);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("增强功能B");
    }
}
