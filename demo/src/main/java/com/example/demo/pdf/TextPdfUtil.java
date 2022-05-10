package com.example.demo.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.List;
import java.util.Map;

public class TextPdfUtil {


    public static ByteArrayOutputStream mergePDF(List<byte[]> list) throws IOException, DocumentException {
        Document document = null;
        ByteArrayOutputStream out;
        try {
            document = new Document(new PdfReader(list.get(0)).getPageSize(1));
            out = new ByteArrayOutputStream();
            PdfCopy pdfCopy = new PdfCopy(document, out);
            document.open();

            for (byte[] bytes : list) {
                PdfReader pdfReader = new PdfReader(bytes);
                int numberOfPages = pdfReader.getNumberOfPages();
                for (int i = 1; i <= numberOfPages; i++) {
                    document.newPage();
                    PdfImportedPage importedPage = pdfCopy.getImportedPage(pdfReader, i);
                    pdfCopy.addPage(importedPage);
                }
            }
        } finally {
            if (document != null) {
                document.close();
            }
        }
        return out;
    }

    /**
     * 利用模板生成pdf.
     *
     * @param dataMap
     * @param tempPath
     * @return
     */
    public static ByteArrayOutputStream pdfOutPut(Map<String, String> dataMap, String tempPath) {
        // 加载模板路径
        ClassPathResource classPathResource = new ClassPathResource(tempPath);
        String templatePath = classPathResource.getPath();

        PdfReader reader;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfStamper stamper;
        try {
            // 输入-pdf模板
            reader = new PdfReader(templatePath);
            // 输出
            bos = new ByteArrayOutputStream();

            // 核心-stamper
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            fillData(dataMap, form);

            stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            stamper.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return bos;
    }

    /**
     * 填充
     *
     * @param dataMap
     * @param form
     * @throws DocumentException
     * @throws IOException
     */
    private static void fillData(Map<String, String> dataMap, AcroFields form) throws DocumentException, IOException {
        setFontType(form);
        fillContent(dataMap, form);
//        fillFixedPositionImages(imageMap, stamper, form);
    }

    /**
     * 设置字体-处理中文
     *
     * @param form
     * @throws DocumentException
     * @throws IOException
     */
    private static void setFontType(AcroFields form) throws DocumentException, IOException {
        //文字类的内容处理
        ClassPathResource fontResource = new ClassPathResource("templates/simsun.ttc");
        BaseFont bf = BaseFont.createFont(fontResource.getPath() + ",1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        form.addSubstitutionFont(bf);
    }

    /**
     * 填充文字.
     *
     * @param dataMap
     * @param form
     * @throws IOException
     * @throws DocumentException
     */
    private static void fillContent(Map<String, String> dataMap, AcroFields form) throws IOException, DocumentException {
        for (String key : dataMap.keySet()) {
            String value = dataMap.get(key);
            // 设置字体大小
            form.setFieldProperty(key, "textsize", 10f, null);
            form.setField(key, value,true);
        }
    }

    /**
     * 填充固定位置图片.
     *
     * @param imageMap
     * @param stamper
     * @param form
     * @throws IOException
     * @throws DocumentException
     */
    private static void fillFixedPositionImages(Map<String, File> imageMap, PdfStamper stamper, AcroFields form) throws IOException, DocumentException {
        //图片类的内容处理
        if (imageMap != null) {
            for (String key : imageMap.keySet()) {
                File value = imageMap.get(key);
                String imagePath = value.getAbsolutePath();
                int pageNo = form.getFieldPositions(key).get(0).page;
                Rectangle signRect = form.getFieldPositions(key).get(0).position;
                float x = signRect.getLeft();
                float y = signRect.getBottom();
                //根据路径读取图片
                Image image = Image.getInstance(imagePath);
                //获取图片页面
                PdfContentByte under = stamper.getOverContent(pageNo);
                //图片大小自适应
                image.scaleToFit(signRect.getWidth(), signRect.getHeight());
                //添加图片
                image.setAbsolutePosition(x, y);
                under.addImage(image);
                value.delete();
            }
        }
    }
}
