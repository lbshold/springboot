package top.lconcise.design_demo.combat.mapper;

import top.lconcise.design_demo.combat.entity.Apple;

/**
 * @author: liusj
 * @date: 2022/5/26
 */
public interface TemplateMapper<T> {

    T selectById(Long id);
}
