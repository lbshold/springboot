package top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory;

import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.RuleConfigParser.IRuleConfigParser;
import top.lconcise.design_demo.design_mode.creaction.factory_design.simple_factory.exception.InvalidRuleConfigException;

/**
 * 简单工厂模式
 *
 * @author: liusj
 * @date: 2022/3/11
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParseFactory.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFileExtension);
        }

        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
