package top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory;

import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfigParser.IRuleConfigParser;
import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfigParser.JsonRuleConfigParser;
import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfigParser.XmlRuleConfigParser;
import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfigParser.YamlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2022/3/16
 */
public class RuleConfigParseFactory2 {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new JsonRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat);
        return parser;
    }
}
