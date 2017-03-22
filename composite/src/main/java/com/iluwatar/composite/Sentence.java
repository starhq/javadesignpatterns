package com.iluwatar.composite;

import java.util.List;

/**
 * Created by starhq on 2017/3/22.
 */
public class Sentence extends LetterComposite {

    public Sentence(List<Word> words) {
        for (Word word : words) {
            this.add(word);
        }
    }

    @Override
    protected void printThisBefore() {

    }

    @Override
    protected void printThisAfter() {
        System.out.print(".");
    }
}
