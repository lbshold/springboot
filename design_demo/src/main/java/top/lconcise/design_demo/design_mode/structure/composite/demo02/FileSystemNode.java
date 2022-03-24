package top.lconcise.design_demo.design_mode.structure.composite.demo02;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();
    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}
