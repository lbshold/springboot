package top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfigParser;

import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfig;

/**
 * @author: liusj
 * @date: 2022/3/11
 */
public interface IRuleConfigParser {

    RuleConfig parse(String configText);
}
