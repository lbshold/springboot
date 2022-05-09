package com.example.demo.controller;

import cn.hutool.json.JSONObject;
import com.example.demo.pdf.TextPdfUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2021/11/23
 */
@RestController
public class HelloController {

    public static String REGISTER = "templates/register.pdf";

    @GetMapping("/test02")
    public void test02(HttpServletResponse response) {
        String str = "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称06加名称名称加名称07加名称名称加名称08加名称名称加名称09加名称名称加名称10加名称名称加名称"+ // 行100字符
                "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称06加名称名称加名称07加名称名称加名称08加名称名称加名称09加名称名称加名称10加名称名称加名称"+
                "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称06加名称名称加名称07加名称名称加名称08加名称名称加名称09加名称名称加名称10加名称名称加名称";

        String str02 = "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称"+ // 行50字符
                "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称"+
                "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称";
        System.out.println("文字长度："+str.length());
        System.out.println("文字长度："+str02.length());

        try {
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("toggle_2", "On");
            dataMap.put("fill_1", "2022年5月9日");
            dataMap.put("fill_2", "2022年5月9日");
            dataMap.put("fill_3", "名称名称名称名称名称");
            dataMap.put("fill_4", "名称名称名称名称名称");
            dataMap.put("fill_15", str);
            dataMap.put("fill_23", str02);
            ByteArrayOutputStream out1 = TextPdfUtil.pdfOutPut(dataMap, null, REGISTER);
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
}
