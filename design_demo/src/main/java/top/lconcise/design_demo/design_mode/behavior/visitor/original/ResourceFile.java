package top.lconcise.design_demo.design_mode.behavior.visitor.original;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void extract2txt();
}
