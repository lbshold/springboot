package com.example.demo.decorete;

/**
 * @author: liusj
 * @date: 2021/11/11
 */
public class BaseDecorate  implements Decorate{

    @Override
    public void decorate() {
        System.out.println("基础装饰：墙面、地面。");
    }
}
