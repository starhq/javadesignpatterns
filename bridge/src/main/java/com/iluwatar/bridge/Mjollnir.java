package com.iluwatar.bridge;

/**
 * Created by starhq on 2017/3/20.
 */
public class Mjollnir extends FlyingMagicWeaponImpl {
    @Override
    public void weidImp() {
        System.out.println("wielding Mjollnir");
    }

    @Override
    public void swingImp() {
        System.out.println("swinging Mjollnir");
    }

    @Override
    public void unweidImp() {
        System.out.println("unwielding Mjollnir");
    }

    @Override
    public void flyImp() {
        System.out.println("Mjollnir hits the enemy in the air and returns back to the owner's hand");
    }
}
