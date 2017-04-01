package com.iluwatar.flux.action;

/**
 * Created by starhq on 2017/4/1.
 */
public enum MenuItem {
    HOME("Home"), PRODUCTS("Products"), COMPANY("Company");

    private String title;

    MenuItem(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
