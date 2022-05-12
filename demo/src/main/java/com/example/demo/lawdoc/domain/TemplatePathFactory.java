package com.example.demo.lawdoc.domain;

import com.example.demo.lawdoc.entity.LawFileFinalReport;
import com.example.demo.lawdoc.entity.LawFileRemarks;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2022/5/12
 */
public class TemplatePathFactory {

    private static final Map<Class, String> cachedPaths = new HashMap<>();

    static {
        cachedPaths.put(LawFileFinalReport.class, "FinalReport.pdf");
        cachedPaths.put(LawFileRemarks.class, "templates/Remarks.pdf");
    }

    public static String getTemplatePath(Class clazz) {
        return cachedPaths.get(clazz);
    }
}
