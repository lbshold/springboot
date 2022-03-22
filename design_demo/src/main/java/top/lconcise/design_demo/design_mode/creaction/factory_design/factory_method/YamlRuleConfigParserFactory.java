package top.lconcise.design_demo.design_mode.creaction.factory_design.factory_method;

import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.IRuleConfigParser;
import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.YamlRuleConfigParser;

/**
 * @author: liusj
 * @date: 2022/3/16
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
