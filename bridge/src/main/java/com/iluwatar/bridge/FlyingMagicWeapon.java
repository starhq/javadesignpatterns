package com.iluwatar.bridge;

/**
 * Created by starhq on 2017/3/20.
 */
public class FlyingMagicWeapon extends MagicWeapon {

    public FlyingMagicWeapon(FlyingMagicWeaponImpl imp) {
        super(imp);
    }

    public FlyingMagicWeaponImpl getImp() {
        return (FlyingMagicWeaponImpl) imp;
    }

    @Override
    public void wield() {
        getImp().weidImp();
    }

    @Override
    public void swing() {
        getImp().swingImp();
    }

    @Override
    public void unwield() {
        getImp().unweidImp();
    }

    public void fly() {
        getImp().flyImp();
    }

}
