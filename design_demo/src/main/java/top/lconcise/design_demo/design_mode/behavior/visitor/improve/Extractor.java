package top.lconcise.design_demo.design_mode.behavior.visitor.improve;

/**
 * @author: liusj
 * @date: 2022/3/29
 */
public class Extractor {
    
    public void extract2txt(PDFFile pdfFile){
        System.out.println("Extract PDF...");
    }

    public void extract2txt(PPTFile pdfFile){
        System.out.println("Extract PPT...");
    }
}
