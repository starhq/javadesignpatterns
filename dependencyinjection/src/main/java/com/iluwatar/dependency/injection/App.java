package com.iluwatar.dependency.injection;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SimpleWizard simpleWizard = new SimpleWizard();
        simpleWizard.smoke();

        AdvancedWizard advancedWizard = new AdvancedWizard(new SecondBreakfastTobacco());
        advancedWizard.smoke();

        Injector injector = Guice.createInjector(new TobaccoModule());
        GuiceWizard guiceWizard = injector.getInstance(GuiceWizard.class);
        guiceWizard.smoke();
    }
}
