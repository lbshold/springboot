package com.example.demo.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * generate PDF tools.
 *
 * @author: liusj
 * @date: 2022/5/11
 */
public class TextPdfUtil {

    /**
     * 合并 PDF.
     *
     * @param list
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static ByteArrayOutputStream mergePDF(List<byte[]> list) throws IOException, DocumentException {
        //中文字符处理
        ClassPathResource fontResource = new ClassPathResource("templates/simsun.ttc");
        BaseFont bf = BaseFont.createFont(fontResource.getPath() + ",1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(bf, 12f, Font.NORMAL);

        Document document = null;
        ByteArrayOutputStream out;
        try {
            document = new Document(new PdfReader(list.get(0)).getPageSize(1));
            out = new ByteArrayOutputStream();
            PdfCopy pdfCopy = new PdfCopy(document, out);
            document.open();

            int pageNum = 1;
            for (int i = 0; i < list.size(); i++) {
                byte[] bytes = list.get(i);
                PdfReader pdfReader = new PdfReader(bytes);
                int numberOfPages = pdfReader.getNumberOfPages();
                for (int j = 1; j <= numberOfPages; j++) {
                    document.newPage();
                    PdfImportedPage importedPage = pdfCopy.getImportedPage(pdfReader, j);
                    // 插入页码
                    if (i >= 2) { // 排除封页和目录，这里属于定制内容
                        PdfCopy.PageStamp stamp = pdfCopy.createPageStamp(importedPage);
                        ColumnText.showTextAligned(stamp.getUnderContent(),
                                Element.ALIGN_CENTER,
                                new Phrase(new Paragraph(String.format("第 %d 页", pageNum), font)), 300f, 25f, 0f);
                        pageNum++;
                        stamp.alterContents();
                    }
                    pdfCopy.addPage(importedPage);
                }
                pdfReader.close();
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
     * @param fillContent
     * @param tempPath
     * @return
     */
    public static ByteArrayOutputStream pdfOutPut(FillContent fillContent, String tempPath, float fontSize) throws IOException, DocumentException {
        // 加载模板路径
        ClassPathResource classPathResource = new ClassPathResource(tempPath);
        String templatePath = classPathResource.getPath();

        PdfReader reader;
        ByteArrayOutputStream bos;
        PdfStamper stamper = null;
        try {
            // 输入-pdf模板
            reader = new PdfReader(templatePath);
            // 输出
            bos = new ByteArrayOutputStream();

            // 核心-stamper
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            //中文字符处理
            ClassPathResource fontResource = new ClassPathResource("templates/simsun.ttc");
            BaseFont bf = BaseFont.createFont(fontResource.getPath() + ",1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            form.addSubstitutionFont(bf);

            // 填充文字
            fillContent(fillContent, form, fontSize);

            // 填充图片
            fillImage(fillContent, stamper, form);

            stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
        } finally {
            if (stamper != null) {
                stamper.close();
            }
        }
        return bos;
    }

    /**
     * Url转File.
     */
    public static File getFileFromUrl(String url) {
        //对本地文件命名
        String fileName = UUID.randomUUID().toString();
        File file = null;

        URL urlFile;
        InputStream inStream = null;
        OutputStream os = null;
        try {
            file = File.createTempFile("net_url", fileName);
            //下载
            urlFile = new URL(url);
            inStream = urlFile.openStream();
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

    /**
     * url 转 ByteArrayOutputStream.
     */
    public static ByteArrayOutputStream getBosFromUrl(String url) throws IOException {
        URL urlPdf =new URL(url);
        InputStream bis = urlPdf.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);

        byte[] temp = new byte[2048];
        int size = 0;
        while ((size = bis.read(temp)) != -1) {
            bos.write(temp, 0, size);
        }
        bis.close();
        return bos;
    }

    /**
     * PDF模板填充内容.
     *
     * @param fillContent
     * @param form
     * @param fontSize
     * @throws IOException
     * @throws DocumentException
     */
    private static void fillContent(FillContent fillContent, AcroFields form, float fontSize) throws IOException, DocumentException {
        Map<String, String> contentMap = fillContent.getContentMap();
        for (String key : contentMap.keySet()) {
            String value = contentMap.get(key);
            // 设置字体大小
            form.setFieldProperty(key, "textsize", fontSize, null);
            form.setField(key, value, true);
        }
    }

    /**
     * PDF模板填充图片.
     *
     * @param fillContent
     * @param stamper
     * @param form
     * @throws IOException
     * @throws DocumentException
     */
    private static void fillImage(FillContent fillContent, PdfStamper stamper, AcroFields form) throws IOException, DocumentException {
        Map<String, List<File>> imageMap = fillContent.getImageMap();
        if (imageMap != null && imageMap.size() > 0) {
            Set<Map.Entry<String, List<File>>> entries = imageMap.entrySet();
            for (Map.Entry<String, List<File>> entry : entries) {
                String param = entry.getKey();
                List<File> picFiles = entry.getValue();
                if (StringUtils.isEmpty(param) || picFiles.size() == 0) continue;
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
        }
    }

}
