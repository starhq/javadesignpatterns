package com.iluwatar.bridge;

/**
 * Created by starhq on 2017/3/20.
 */
public class Stormbringer extends SoulEatingMagicWeaponImpl {

    @Override
    public void weidImp() {
        System.out.println("wielding Stormbringer");
    }

    @Override
    public void swingImp() {
        System.out.println("swinging Stormbringer");
    }

    @Override
    public void unweidImp() {
        System.out.println("unwielding Stormbringer");
    }

    @Override
    public void eatSoulImp() {
        System.out.println("Stormbringer devours the enemy's soul");
    }
}
