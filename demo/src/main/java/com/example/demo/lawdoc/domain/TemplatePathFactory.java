package com.example.demo.lawdoc.domain;

import com.example.demo.lawdoc.entity.LawDocInfo;
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
        cachedPaths.put(LawDocInfo.class, "templates/Title.pdf"); // 卷宗封面
        cachedPaths.put(LawFileRemarks.class, "templates/Remarks.pdf"); // 卷内备考表
        cachedPaths.put(LawFileFinalReport.class, "templates/Report.pdf");// 案件结案报告
    }

    public static String getTemplatePath(Class clazz) {
        return cachedPaths.get(clazz);
    }
}
