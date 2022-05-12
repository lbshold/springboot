package com.example.demo.lawdoc.domain;

import com.example.demo.lawdoc.entity.BaseDataTemplate;
import com.example.demo.lawdoc.entity.LawDocFile;
import com.example.demo.pdf.FillContent;
import com.example.demo.pdf.TextPdfUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/5/12
 */
public class PdfFactory {

    /**
     * 根据单个模板生产相应的PDF.
     *
     * @param baseDataTemplate
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws IOException
     * @throws DocumentException
     */
    public static ByteArrayOutputStream crateSinglePdf(BaseDataTemplate baseDataTemplate)
            throws IllegalAccessException, IllegalArgumentException, IOException, DocumentException {
        FillContent fillContent = baseDataTemplate.generate();
        return TextPdfUtil.pdfOutPut(fillContent, TemplatePathFactory.getTemplatePath(baseDataTemplate.getClass()));
    }

    /**
     * 生产目录.
     */
    public static ByteArrayOutputStream createCatalog(List<LawDocFile> lawDocFiles) throws DocumentException, IOException {
        // 1.新建document对象
        Document doc = new Document(PageSize.A4, 30, 30, 50, 30);//SUPPRESS
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, bos);
        doc.open();
        // 字体设置
        ClassPathResource fontResource = new ClassPathResource("templates/simsun.ttc");
        BaseFont baseFont = BaseFont.createFont(fontResource.getPath() + ",1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        //标题
        Paragraph firstParagraph = new Paragraph();
        firstParagraph.setAlignment(Element.ALIGN_CENTER);
        firstParagraph.setSpacingAfter(15);
        //文本块
        Chunk firstChunk = new Chunk("执法卷宗目录", new Font(baseFont, 24, Font.BOLD));
        firstChunk.setLineHeight(30);
        firstParagraph.add(firstChunk);
        firstParagraph.setSpacingAfter(20);
        doc.add(firstParagraph);

        // 创建字体对象
        Font font = new Font(baseFont, 14, Font.NORMAL);
        Font font2 = new Font(baseFont, 15, Font.NORMAL);
        // 添加5列表格
        PdfPTable table = new PdfPTable(5);

        // 设置各列列宽
        table.setTotalWidth(new float[]{60, 120, 110, 60, 220});

        ArrayList<PdfPRow> rows = table.getRows();

        PdfPCell[] cells = new PdfPCell[5];
        PdfPRow pdfPRow = new PdfPRow(cells);
        cells[0] = getPdfCell("序号", font);
        cells[1] = getPdfCell("材料名称", font);
        cells[2] = getPdfCell("文号", font);
        cells[3] = getPdfCell("页码", font);
        cells[4] = getPdfCell("备注", font);
        rows.add(pdfPRow);

        for (LawDocFile lawDocFile : lawDocFiles) {
            cells = new PdfPCell[5];
            pdfPRow = new PdfPRow(cells);
            cells[0] = getPdfCell(lawDocFile.getSort().toString(), font);
            cells[1] = getPdfCell(lawDocFile.getFileName(), font);
            cells[2] = getPdfCell(lawDocFile.getLawNum(), font);
            cells[3] = getPdfCell(lawDocFile.getPageNum(), font);
            cells[4] = getPdfCell(lawDocFile.getDescription(), font);
            rows.add(pdfPRow);
        }

        doc.add(table);
        doc.close();
        return bos;
    }

    private static PdfPCell getPdfCell(String content, Font font) {
        PdfPCell pdfPCell = new PdfPCell(new Paragraph(content, font));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setMinimumHeight(30);
        return pdfPCell;
    }

    private static PdfPCell getPdfCellLeft(String content, Font font) {
        PdfPCell pdfPCell = new PdfPCell(new Paragraph(content, font));
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setMinimumHeight(30);
        return pdfPCell;
    }
}
