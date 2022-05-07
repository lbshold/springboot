package com.example.demo.decorete;

/**
 * @author: 王坤
 * @date: 2020/09/24 10:16
 */
public class StringTools {

    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }

    /**
     * 转换字符串，所有偶数位的值放前面
     * @param s
     * @return
     */
    public static String convert(String s) {
        String newStr1 = new String();
        String newStr2 = new String();
        for(int i=0;i<s.length();i++){
            if (i%2==0){
                newStr1 += s.charAt(i);
            }else {
                newStr2 += s.charAt(i);
            }
        }
        return newStr1+newStr2;
    }
}
