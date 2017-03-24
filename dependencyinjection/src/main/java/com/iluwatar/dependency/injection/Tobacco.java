package com.iluwatar.dependency.injection;

/**
 * Created by starhq on 2017/3/24.
 */
public abstract class Tobacco {

    public void smoke(Wizard wizard) {
        System.out.println(String.format("%s smoking %s", wizard.getClass().getSimpleName(), this
                .getClass().getSimpleName()));
    }
}
