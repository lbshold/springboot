package top.lconcise.design_demo.design_mode.behavior.visitor.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class Demo {
    public static void main(String[] args) {
        List<ResourceFile> resourceFileList = new ArrayList<>();
        Extractor extractor = new Extractor();
        for (ResourceFile resourceFile : resourceFileList) {
            resourceFile.accept(extractor);
        }
    }
}
