package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liusj
 * @date: 2021/11/23
 */
@RestController
public class HelloController {


    @GetMapping("/test01")
    public void test() {
        System.out.println("test0-test");
        System.out.println("testst-nes");


        System.out.println("2222222222222222222");
        System.out.println();
    }
}
