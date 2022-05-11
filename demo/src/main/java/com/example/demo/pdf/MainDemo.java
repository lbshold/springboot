package com.example.demo.pdf;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liusj
 * @date: 2022/5/9
 */
public class MainDemo {



    public static void main(String[] args) {
        String str02 = "01加名称名称加名称02加名称名称加名称03加名称名称加名称03加名称名称加名称05加名称名称加名称06加名称名称加名称07加名称名称加名称08加名称名称加名称09加名称名称加名称10加名称名称加名称";
//        System.out.println(str02.length());

        Map<String,Double> map = new HashMap();
        double dou = 19670470;
        map.put("new",dou);

        DecimalFormat format =new DecimalFormat("#");
        System.out.println(format.format(map.get("new")));
    }
}
