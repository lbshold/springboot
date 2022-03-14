package top.lconcise.design_demo.design_mode.factory_design;

/**
 * @author: liusj
 * @date: 2022/3/11
 */
public interface IRuleConfigParser {

    RuleConfig parse(String configText);
}
