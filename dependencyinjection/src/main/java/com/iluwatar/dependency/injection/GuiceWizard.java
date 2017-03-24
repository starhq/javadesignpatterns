package com.iluwatar.dependency.injection;

import javax.inject.Inject;

/**
 * Created by starhq on 2017/3/24.
 */
public class GuiceWizard implements Wizard {

    private final Tobacco tobacco;

    @Inject
    public GuiceWizard(Tobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public void smoke() {
        tobacco.smoke(this);
    }
}
