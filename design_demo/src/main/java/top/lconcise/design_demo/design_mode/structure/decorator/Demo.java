package top.lconcise.design_demo.design_mode.structure.decorator;

import java.io.*;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public class Demo {

    public static void main(String[] args) throws FileNotFoundException {
        Decorator decorator = new Decorator();

        DecoratorA decoratorA = new DecoratorA(decorator);
        DecoratorB decoratorB = new DecoratorB(decorator);

        decoratorA.decorate();
        decoratorB.decorate();
    }
}
