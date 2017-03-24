package com.iluwatar.dependency.injection;

/**
 * Created by starhq on 2017/3/24.
 */
public class AdvancedWizard implements Wizard {

    private final Tobacco tobacco;

    public AdvancedWizard(Tobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public void smoke() {
        tobacco.smoke(this);
    }
}
