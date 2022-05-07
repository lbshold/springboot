package top.lconcise.design_demo.design_mode.behavior.visitor.original;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class Demo {
    public static void main(String[] args) {
        List<ResourceFile> resourceFileList = new ArrayList<>();
        resourceFileList.add(new PDFFile(""));
        resourceFileList.add(new PPTFile(""));
        resourceFileList.add(new WordFile(""));
        for (ResourceFile resourceFile : resourceFileList) {
            resourceFile.extract2txt();
        }
    }
}
