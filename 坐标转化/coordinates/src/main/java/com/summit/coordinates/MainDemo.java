package com.summit.coordinates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liusj on 2019/5/27
 */
public class MainDemo {

    public static void main(String[] args) {
//        MyObject{longitude='  119°10′40.66″', latitude=' 39°42′50.52″'}
//        MyObject{longitude=' 119°6′14.13″', latitude='  39°37′29.42″'}
//        MyObject{longitude='117°48′29.97″', latitude='40′53′14.03″'}
        //                    116°51′33.9″
        String REGEX = "^\\d+" + "(\\." + "\\d+)?$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher("115");
        System.out.println(matcher.find());

        String str = "  123  ";
        System.out.println("hello"+str+"hello");
        System.out.println("hello"+str.trim()+"hello");
    }
}
