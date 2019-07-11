package top.lconcise.demo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by liusj on 2019/7/11
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                "top.lconcise.demo.domain.Demo1",
                "top.lconcise.demo.domain.Demo2",
                "top.lconcise.demo.domain.Demo3"
        };
    }
}
