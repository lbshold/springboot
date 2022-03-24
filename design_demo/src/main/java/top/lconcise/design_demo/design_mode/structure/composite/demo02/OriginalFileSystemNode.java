package top.lconcise.design_demo.design_mode.structure.composite.demo02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public class OriginalFileSystemNode {
    private String path;
    private boolean isFile;
    private List<OriginalFileSystemNode> subNodes = new ArrayList<>();

    public OriginalFileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {
        if (isFile) {
            return 1;
        }
        int numOfFiles = 0;
        for (OriginalFileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    public long countSizeOfFiles() {
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) return 0;
            return file.length();
        }
        long sizeOfFiles = 0;
        for (OriginalFileSystemNode fileOrDir : subNodes) {
            sizeOfFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public String getPath() {
        return path;
    }

    public void addSubNode(OriginalFileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(OriginalFileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
