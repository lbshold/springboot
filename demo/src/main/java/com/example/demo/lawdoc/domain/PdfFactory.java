package com.example.demo.lawdoc.domain;

import com.example.demo.lawdoc.entity.BaseDataTemplate;
import com.example.demo.lawdoc.entity.LawFileFinalReport;
import com.example.demo.pdf.FillContent;
import com.example.demo.pdf.TextPdfUtil;
import com.itextpdf.text.DocumentException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
}
