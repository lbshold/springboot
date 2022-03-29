package top.lconcise.design_demo.design_mode.behavior.visitor.original;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class WordFile extends ResourceFile {
    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public void extract2txt() {
        System.out.println("Extract word。。。");
    }
}
