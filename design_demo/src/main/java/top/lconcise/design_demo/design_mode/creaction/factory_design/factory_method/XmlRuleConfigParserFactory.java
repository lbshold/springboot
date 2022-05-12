package top.lconcise.design_demo.design_mode.creaction.factory_design.factory_method;

import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfigParser.IRuleConfigParser;
import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfigParser.XmlRuleConfigParser;

/**
 * @author: liusj
 * @date: 2022/3/16
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory{

    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
