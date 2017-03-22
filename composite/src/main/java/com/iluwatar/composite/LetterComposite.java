package com.iluwatar.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by starhq on 2017/3/22.
 */
public abstract class LetterComposite {

    private List<LetterComposite> children = new ArrayList<>();

    public void add(LetterComposite letterComposite) {
        children.add(letterComposite);
    }

    public int count() {
        return children.size();
    }

    protected abstract void printThisBefore();

    protected abstract void printThisAfter();

    public void print() {
        printThisBefore();

        for (LetterComposite letter : children) {
            letter.print();
        }

        printThisAfter();
    }
}
