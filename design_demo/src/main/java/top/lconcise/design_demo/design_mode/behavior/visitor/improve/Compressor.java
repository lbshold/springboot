package top.lconcise.design_demo.design_mode.behavior.visitor.improve;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class Compressor {

    public void compress(PDFFile pdfFile) {
        System.out.println("Compress pdf...");
    }

    public void compress(PPTFile pptFile) {
        System.out.println("Compress ppt...");
    }
}
