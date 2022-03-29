package top.lconcise.design_demo.design_mode.behavior.visitor.improve02;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class Compressor implements Visitor {

    @Override
    public void visit(PDFFile pdfFile) {
        System.out.println("Compress pdf...");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("Compress ppt...");
    }
}
