package top.lconcise.design_demo.combat.mapper;

import top.lconcise.design_demo.combat.Subscribe;
import top.lconcise.design_demo.combat.entity.Apple;

/**
 * @author: liusj
 * @date: 2022/5/26
 */
@Subscribe(desc = "apple")
public interface AppleMapper extends TemplateMapper<Apple> {

    Apple selectById(Long id);
}
