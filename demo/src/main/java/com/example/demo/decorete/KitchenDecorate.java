package com.example.demo.decorete;

/**
 * @author: liusj
 * @date: 2021/11/11
 */
public class KitchenDecorate extends AbstractDecorate{

    public KitchenDecorate(Decorate decorate) {
        super(decorate);
    }

    @Override
    public void decorate() {
        super.decorate();
        System.out.println("装饰厨房。");
    }
}
