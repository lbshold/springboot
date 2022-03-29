package top.lconcise.design_demo.design_mode.behavior.visitor.improve;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void accept(Extractor extractor);
    public abstract void accept(Compressor extractor);
}
