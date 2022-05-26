package top.lconcise.design_demo.combat.mapper;

import top.lconcise.design_demo.combat.Subscribe;
import top.lconcise.design_demo.combat.entity.Banana;

/**
 * @author: liusj
 * @date: 2022/5/26
 */
@Subscribe(desc = "banana")
public interface BananaMapper extends TemplateMapper<Banana> {

    Banana selectById(Long id);
}
