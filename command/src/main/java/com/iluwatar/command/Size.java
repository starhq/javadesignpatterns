package com.iluwatar.command;

/**
 * Created by starhq on 2017/3/22.
 */
public enum Size {
    SMALL("small"), NORMAL("normal"), LARGE("large"), UNDEFINED("");

    private String title;

    Size(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
