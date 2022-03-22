package top.lconcise.design_demo.design_mode.structure.decorator;

import org.yaml.snakeyaml.events.Event;

/**
 * @author: liusj
 * @date: 2022/3/22
 */
public abstract class BaseDecorator {

    private IDecorator decorator;

    public BaseDecorator(IDecorator decorator) {
        this.decorator = decorator;
    }

    public void decorate(){
        if(decorator!=null){
            decorator.decorate();
        }
    }
}
