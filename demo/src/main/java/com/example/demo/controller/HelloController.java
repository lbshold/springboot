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

        try {
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("a","2022年5月9日");
            dataMap.put("b","2022年5月9日");
            dataMap.put("c","名称名称名称名称名称");
            dataMap.put("d","名称名称名称名称名称");
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
