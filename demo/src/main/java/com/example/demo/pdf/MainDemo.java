package com.example.demo.pdf;

import com.example.demo.lawdoc.domain.TemplatePathFactory;
import com.example.demo.lawdoc.entity.LawFileFinalReport;

import java.util.Map;
import java.util.Set;

/**
 * @author: liusj
 * @date: 2022/5/9
 */
public class MainDemo {

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException {
        LawFileFinalReport fileFinalReport = LawFileFinalReport.builder()
                .name("罗永浩")
                .sex("男")
                .phone("15114818659")
                .idCardNo("6101199612151215")
                .birthday("1994年12月12日")
                .build();


        System.out.println(TemplatePathFactory.getTemplatePath(fileFinalReport.getClass()));
    }
}
