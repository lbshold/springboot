package top.lconcise.design_demo.design_mode.behavior.visitor.improve02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class Demo {
    public static void main(String[] args) {
        List<ResourceFile> resourceFileList = new ArrayList<>();
        Visitor extractor = new Extractor();
        Visitor compressor = new Compressor();
        for (ResourceFile resourceFile : resourceFileList) {
            resourceFile.accept(extractor);
            resourceFile.accept(compressor);
        }
    }
}
