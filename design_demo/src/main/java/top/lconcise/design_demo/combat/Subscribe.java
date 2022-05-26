package top.lconcise.design_demo.combat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文书Mapper类注解，让模板和Mapper对应关联起来。
 *
 * @author: liusj
 * @date: 2022/5/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Subscribe {

    String desc() default "";
}
