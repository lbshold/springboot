package top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.exception;

/**
 * @author: liusj
 * @date: 2022/3/11
 */
public class InvalidRuleConfigException extends RuntimeException {

    public InvalidRuleConfigException(String message) {
        super(message);
    }
}
