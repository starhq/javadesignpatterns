package com.iluwatar.composite;

import java.util.List;

/**
 * Created by starhq on 2017/3/22.
 */
public class Word extends LetterComposite {

    public Word(List<Letter> letters) {
        for (Letter letter : letters) {
            this.add(letter);
        }
    }

    @Override
    protected void printThisBefore() {
        System.out.println(" ");
    }

    @Override
    protected void printThisAfter() {

    }
}
