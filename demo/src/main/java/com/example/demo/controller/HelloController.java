package com.example.demo.controller;

import cn.hutool.json.JSONObject;
import com.example.demo.lawdoc.domain.PdfFactory;
import com.example.demo.lawdoc.entity.LawFileRemarks;
import com.example.demo.pdf.FillContent;
import com.example.demo.pdf.TextPdfUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2021/11/23
 */
@RestController
public class HelloController {

    public static final String str = "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称06加名称名称加名称07加名称名称加名称08加名称名称加名称09加名称名称加名称10加名称名称加名称" + // 行100字符
            "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称06加名称名称加名称07加名称名称加名称08加名称名称加名称09加名称名称加名称10加名称名称加名称" +
            "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称06加名称名称加名称07加名称名称加名称08加名称名称加名称09加名称名称加名称10加名称名称加名称";

    public static final String str02 = "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称" + // 行50字符
            "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称" +
            "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称";
    public static String REGISTER = "templates/register.pdf";
    public static String PictureRegister = "templates/PictureRegister.pdf";

    @GetMapping("/pdf")
    public void test02(HttpServletResponse response) {

        System.out.println("文字长度：" + str.length());
        System.out.println("文字长度：" + str02.length());

        try {
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("toggle_1", "On");
            dataMap.put("toggle_2", "On");
            dataMap.put("toggle_6", "On");
            dataMap.put("fill_1", "01加名称名称加名称02加名称名称加名称");
            dataMap.put("fill_2", "2022年5月9日");
            dataMap.put("fill_3", "名称名称名称名称名称");
            dataMap.put("fill_4", "名称名称名称名称名称");
            dataMap.put("fill_8", "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称");
            dataMap.put("fill_15", str);
            dataMap.put("fill_23", str02);
            dataMap.put("pageNumber", "1");
            FillContent fillContent = new FillContent();
            fillContent.setContentMap(dataMap);
            ByteArrayOutputStream out1 = TextPdfUtil.pdfOutPut(fillContent, REGISTER);
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("案件受理登记表", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            out1.writeTo(out);
        } catch (Exception e) {
            e.printStackTrace();
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            JSONObject r = new JSONObject();
            r.put("code", "500");
            r.put("msg", "导出失败,请重试或联系管理员");
            try (ServletOutputStream printOut = response.getOutputStream()) {
                printOut.write(r.toString().getBytes("UTF-8"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @GetMapping("/mergePdf")
    public void test03(HttpServletResponse response) {
        try {
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("toggle_2", "On");
            dataMap.put("fill_1", "2022年5月9日");
            dataMap.put("fill_2", "名称名称名称名称名称");
            dataMap.put("fill_3", "2022年5月9日");
            dataMap.put("fill_4", "名称名称名称名称名称");
            dataMap.put("fill_15", str);
            dataMap.put("fill_23", str02);
            dataMap.put("pageNumber", "1");

            FillContent fillContent = new FillContent();
            fillContent.setContentMap(dataMap);
            ByteArrayOutputStream out1 = TextPdfUtil.pdfOutPut(fillContent, REGISTER);

            dataMap.put("pageNumber", "2");
            ByteArrayOutputStream out2 = TextPdfUtil.pdfOutPut(fillContent, REGISTER);


            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("卷宗", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");

            List<byte[]> list = new ArrayList<>();
            list.add(out1.toByteArray());
            list.add(out2.toByteArray());

            ByteArrayOutputStream result = TextPdfUtil.mergePDF(list);

            result.writeTo(out);
        } catch (Exception e) {
            e.printStackTrace();
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            JSONObject r = new JSONObject();
            r.put("code", "500");
            r.put("msg", "导出失败,请重试或联系管理员");
            try (ServletOutputStream printOut = response.getOutputStream()) {
                printOut.write(r.toString().getBytes("UTF-8"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @GetMapping("/pdfImage")
    public void test01(HttpServletResponse response) {
        String imageUrl = "http://192.168.2.223/file_api/group1/M00/00/3D/wKgC4WJ7FQWAab8fACDzmMupd5s338.jpg";
        try {
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("fill_1", "01加名称名称加名称02加名称名称加名称");
            dataMap.put("fill_2", "2022年5月9日");

            dataMap.put("pageNumber", "1");

            List<File> files = new ArrayList<>();
            File imageFile = TextPdfUtil.getFileFromUrl(imageUrl);
            File imageFile02 = TextPdfUtil.getFileFromUrl(imageUrl);
            File imageFile03 = TextPdfUtil.getFileFromUrl(imageUrl);
            File imageFile04 = TextPdfUtil.getFileFromUrl(imageUrl);
            File imageFile05 = TextPdfUtil.getFileFromUrl(imageUrl);
            File imageFile06 = TextPdfUtil.getFileFromUrl(imageUrl);
            files.add(imageFile);
            files.add(imageFile02);
            files.add(imageFile03);
            files.add(imageFile04);
            files.add(imageFile05);
            files.add(imageFile06);

            FillContent fillContent = new FillContent();
            fillContent.setContentMap(dataMap);
            Map<String, List<File>> imageMap = new HashMap<>();
            imageMap.put("imageA", files);
            fillContent.setImageMap(imageMap);

            ByteArrayOutputStream out1 = TextPdfUtil.pdfOutPut(fillContent, PictureRegister);
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("证据照片登记表", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            out1.writeTo(out);
        } catch (Exception e) {
            e.printStackTrace();
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            JSONObject r = new JSONObject();
            r.put("code", "500");
            r.put("msg", "导出失败,请重试或联系管理员");
            try (ServletOutputStream printOut = response.getOutputStream()) {
                printOut.write(r.toString().getBytes("UTF-8"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @GetMapping("/catalog")
    public void test04(HttpServletResponse response) throws IOException, DocumentException {
        // 1.新建documnet对象
        Document doc = new Document(PageSize.A4, 30, 30, 50, 30);//SUPPRESS
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, response.getOutputStream());
        doc.open();
        // 字体设置
        ClassPathResource fontResource = new ClassPathResource("templates/simsun.ttc");
        BaseFont baseFont = BaseFont.createFont(fontResource.getPath() + ",1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);


        //编辑一标题
        //段落
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
        Font font = new Font(baseFont, 14, Font.NORMAL);//SUPPRESS
        Font font2 = new Font(baseFont, 15, Font.NORMAL);//SUPPRESS
        // 添加5列表格
        PdfPTable table = new PdfPTable(5);//SUPPRESS

        // 设置各列列宽
        table.setTotalWidth(new float[]{60, 120, 110, 60, 220});//SUPPRESS

        PdfPCell[] cells = new PdfPCell[5];
//        PdfPRow pdfPRow =new PdfPRow(cells);
//        cells[0] = getPdfCell("序号",font);
//        cells[1] = getPdfCell("材料名称",font);
//        cells[2] = getPdfCell("文号",font);
//        cells[3] = getPdfCell("文号",font);
//        cells[4] = getPdfCell("文号",font);
//        ArrayList<PdfPRow> rows = table.getRows();
//        rows.add(pdfPRow);
        table.addCell(getPdfCell("序号", font2));
        table.addCell(getPdfCell("材料名称", font2));
        table.addCell(getPdfCell("文号", font2));
        table.addCell(getPdfCell("页号", font2));
        table.addCell(getPdfCellLeft("备注", font2));

        doc.add(table);
        doc.close();

        ServletOutputStream out = response.getOutputStream();
        out1.writeTo(out);
        response.setContentType("application/pdf");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("证据照片登记表", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
    }

    @GetMapping("/singlePdf")
    public void test05(HttpServletResponse response) {
        LawFileRemarks fileRemarks = LawFileRemarks.builder()
                .checkBy("罗永浩")
                .createBy("罗永浩")
                .createTime("2022年5月12日")
                .desc(str).build();
        fileRemarks.setLawDocFileName("卷内备考表");

        try {
            ByteArrayOutputStream bos = PdfFactory.crateSinglePdf(fileRemarks);

            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode(fileRemarks.getLawDocFileName(), "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            bos.writeTo(out);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private PdfPCell getPdfCell(String content, Font font) {
        PdfPCell pdfPCell = new PdfPCell(new Paragraph(content, font));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setMinimumHeight(30);
        return pdfPCell;
    }

    private PdfPCell getPdfCellLeft(String content, Font font) {
        PdfPCell pdfPCell = new PdfPCell(new Paragraph(content, font));
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPCell.setMinimumHeight(30);
        return pdfPCell;
    }
}
