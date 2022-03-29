package top.lconcise.design_demo.design_mode.behavior.visitor.improve02;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class PPTFile extends ResourceFile {
    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
