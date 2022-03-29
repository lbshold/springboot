package top.lconcise.design_demo.design_mode.behavior.visitor.improve02;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public interface Visitor {
    void visit(PDFFile pdfFile);

    void visit(PPTFile pptFile);
}
