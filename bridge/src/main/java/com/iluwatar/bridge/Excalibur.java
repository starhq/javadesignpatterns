package com.iluwatar.bridge;

/**
 * Created by starhq on 2017/3/20.
 */
public class Excalibur extends BlindingMagicWeaponImpl {
    @Override
    public void weidImp() {
        System.out.println("wielding Excalibur");
    }

    @Override
    public void swingImp() {
        System.out.println("swinging Excalibur");
    }

    @Override
    public void unweidImp() {
        System.out.println("unwielding Excalibur");
    }

    @Override
    public void blindImp() {
        System.out.println("bright light streams from Excalibur blinding the enemy");
    }
}
