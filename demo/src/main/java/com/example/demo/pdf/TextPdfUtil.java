package com.example.demo.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TextPdfUtil {

    /**
     * 合并单元格
     *
     * @param list
     * @return
     * @throws IOException
     * @throws DocumentException
     */
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
    public static ByteArrayOutputStream pdfOutPut(Map<String, String> dataMap, List<File> picFiles, String tempPath) {
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

            setFontType(form);
            fillContent(dataMap, form);
            fillImages("imageA", picFiles, stamper, form);

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
            form.setField(key, value, true);
        }
    }

    /**
     * 填充固定位置图片.
     *
     * @param stamper
     * @param form
     * @throws IOException
     * @throws DocumentException
     */
    private static void fillImages(String param, List<File> picFiles, PdfStamper stamper, AcroFields form) throws IOException, DocumentException {
        if (StringUtils.isEmpty(param) || picFiles.size() == 0) return;

        List<AcroFields.FieldPosition> fieldPositions = form.getFieldPositions(param);
        if (fieldPositions.size() < picFiles.size()) {
            throw new RuntimeException("插入图片异常");
        }

        for (int i = 0; i < picFiles.size(); i++) {
            File file = picFiles.get(i);
            AcroFields.FieldPosition fieldPosition = fieldPositions.get(i);
            int page = fieldPosition.page;
            Rectangle signRect = fieldPosition.position;
            float x = signRect.getLeft();
            float y = signRect.getBottom();
            //根据路径读取图片
            Image image = Image.getInstance(file.getAbsolutePath());
            //获取图片页面
            PdfContentByte under = stamper.getOverContent(page);
            //图片大小自适应
            image.scaleToFit(signRect.getWidth(), signRect.getHeight());
            //添加图片
            image.setAbsolutePosition(x, y);
            under.addImage(image);
            file.delete();
        }
    }

    public static File getFileFromUrl(String url) throws Exception {
        //对本地文件命名
        String fileName = UUID.randomUUID().toString();
        File file = null;

        URL urlfile;
        InputStream inStream = null;
        OutputStream os = null;
        try {
            file = File.createTempFile("net_url", fileName);
            //下载
            urlfile = new URL(url);
            inStream = urlfile.openStream();
            os = new FileOutputStream(file);

            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
                if (null != inStream) {
                    inStream.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return file;
    }

}
