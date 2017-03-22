package com.iluwatar.command;

/**
 * Created by starhq on 2017/3/22.
 */
public enum Visibility {
    VISIBLE("visible"), INVISIBLE("invisible"), UNDEFINED("");

    private String title;

    Visibility(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
