package top.lconcise.design_demo.design_mode.creaction.factory_design.factory_method;

import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.PropertiesRuleConfigParser;
import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.IRuleConfigParser;

/**
 * @author: liusj
 * @date: 2022/3/16
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
