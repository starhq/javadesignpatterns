package com.iluwatar.flux.action;

/**
 * Created by starhq on 2017/4/1.
 */
public enum Content {
    PRODUCTS("Products - This page lists the company's products."), COMPANY(
            "Company - This page displays information about the company.");

    private String title;

    Content(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
