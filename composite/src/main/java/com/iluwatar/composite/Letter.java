package com.iluwatar.composite;

/**
 * Created by starhq on 2017/3/22.
 */
public class Letter extends LetterComposite {

    private char c;

    public Letter(char c) {
        this.c = c;
    }

    @Override
    protected void printThisBefore() {
        System.out.println(c);
    }

    @Override
    protected void printThisAfter() {

    }
}
