package com.example.demo.controller;

import cn.hutool.json.JSONObject;
import com.example.demo.lawdoc.domain.PdfFactory;
import com.example.demo.lawdoc.entity.*;
import com.example.demo.pdf.FillContent;
import com.example.demo.pdf.TextPdfUtil;
import com.itextpdf.text.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
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
            ByteArrayOutputStream out1 = TextPdfUtil.pdfOutPut(fillContent, REGISTER, 10f);
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
            ByteArrayOutputStream out1 = TextPdfUtil.pdfOutPut(fillContent, REGISTER, 10f);

            dataMap.put("pageNumber", "2");
            ByteArrayOutputStream out2 = TextPdfUtil.pdfOutPut(fillContent, REGISTER, 10f);


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

            ByteArrayOutputStream out1 = TextPdfUtil.pdfOutPut(fillContent, PictureRegister, 10f);
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

    @GetMapping("/completedPdf")
    public void test05(HttpServletResponse response) {
//        LawFileRemarks fileRemarks = LawFileRemarks.builder()
//                .checkBy("罗永浩")
//                .createBy("罗永浩")
//                .createTime("2022年5月12日")
//                .desc(str).build();
//        fileRemarks.setLawDocFileName("卷内备考表");
//        LawDocInfo info = LawDocInfo.builder()
//                .lawcaseNum("案号20220513001")
//                .lawcaseName("案件名称")
//                .archiveHandleResult("处理结果")
//                .lawcaseStartDate(LocalDateTime.now())
//                .lawcaseEndDate(LocalDateTime.now())
//                .archiveQzNum("全卷总号")
//                .archiveAjNum("案件号").build();
        LawFileFinalReport info = LawFileFinalReport.builder()
                .name("罗永浩")
                .sex("男")
                .phone("15114818659")
                .birthday("1989,01.01")
                .idCardNo("610401199202261215")
                .modeOfExecution("On").build();

        try {
            ByteArrayOutputStream bos = PdfFactory.createSinglePdf(info);

            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("PDF", "UTF-8");
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

    @GetMapping("completedCatalog")
    public void test06(HttpServletResponse response) {
        LawDocFile lawDocFile01 = LawDocFile.builder()
                .description("01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称")
                .fileName("文书名称")
                .sort(1)
                .lawNum("5454654645546465")
                .pageNum("1-2")
                .build();
        LawDocFile lawDocFile02 = LawDocFile.builder()
                .description("01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称")
                .fileName("文书名称")
                .sort(2)
                .lawNum("5454654645546465")
                .pageNum("3-4")
                .build();
        List<LawDocFile> lawDocFiles = new ArrayList<>();
        lawDocFiles.add(lawDocFile01);
        lawDocFiles.add(lawDocFile02);
        try {
            ByteArrayOutputStream catalog = PdfFactory.createCatalog(lawDocFiles);

            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("目录", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            catalog.writeTo(out);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/completedFinalReport")
    public void test07(HttpServletResponse response) {
        LawFileRemarks fileRemarks = LawFileRemarks.builder()
                .checkBy("罗永浩")
                .createBy("罗永浩")
                .createTime("2022年5月12日")
                .desc(str).build();
        fileRemarks.setLawDocFileName("卷内备考表");
        LawDocInfo lawDocInfo = LawDocInfo.builder()
                .lawcaseNum("案号20220513001")
                .lawcaseName("案件名称")
                .archiveHandleResult("处理结果")
                .lawcaseStartDate(LocalDateTime.now())
                .lawcaseEndDate(LocalDateTime.now())
                .archiveQzNum("全卷总号")
                .archiveAjNum("案件号").build();
        LawFileFinalReport report = LawFileFinalReport.builder()
                .name("罗永浩")
                .sex("男")
                .phone("15114818659")
                .birthday("1989,01.01")
                .idCardNo("610401199202261215")
                .modeOfExecution("On").build();
        LawDocFile lawDocFile01 = LawDocFile.builder()
                .description("01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称")
                .fileName("文书名称")
                .sort(1)
                .lawNum("5454654645546465")
                .pageNum("1-2")
                .build();
        LawDocFile lawDocFile02 = LawDocFile.builder()
                .description("01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称")
                .fileName("文书名称")
                .sort(2)
                .lawNum("5454654645546465")
                .pageNum("3-4")
                .build();
        List<LawDocFile> lawDocFiles = new ArrayList<>();
        lawDocFiles.add(lawDocFile01);
        lawDocFiles.add(lawDocFile02);
        List<BaseDataTemplate> infoList = new ArrayList<>();
        infoList.add(fileRemarks);
        infoList.add(report);

        try {
            ByteArrayOutputStream finalReport = PdfFactory.mergePdf(lawDocInfo, lawDocFiles, infoList);

            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("目录", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            finalReport.writeTo(out);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
