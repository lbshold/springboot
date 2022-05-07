package com.example.demo.decorete;

/**
 * @author: liusj
 * @date: 2021/11/11
 */
public abstract class AbstractDecorate implements Decorate {

    private Decorate decorate;

    public AbstractDecorate(Decorate decorate) {
        this.decorate = decorate;
    }

    @Override
    public void decorate() {
        if (decorate != null) {
            decorate.decorate();
        }
    }
}
