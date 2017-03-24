package com.iluwatar.dependency.injection;

/**
 * Created by starhq on 2017/3/24.
 */
public class SimpleWizard implements Wizard {

    private OldTobyTobacco tobacco = new OldTobyTobacco();

    @Override
    public void smoke() {
        tobacco.smoke(this);
    }
}
