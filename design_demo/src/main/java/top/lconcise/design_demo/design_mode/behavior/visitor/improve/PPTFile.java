package top.lconcise.design_demo.design_mode.behavior.visitor.improve;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class PPTFile extends ResourceFile {
    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract2txt(this);
    }
}
