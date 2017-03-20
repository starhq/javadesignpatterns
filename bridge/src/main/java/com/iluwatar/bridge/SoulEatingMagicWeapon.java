package com.iluwatar.bridge;

/**
 * Created by starhq on 2017/3/20.
 */
public class SoulEatingMagicWeapon extends MagicWeapon {

    public SoulEatingMagicWeapon(SoulEatingMagicWeaponImpl imp) {
        super(imp);
    }

    @Override
    public SoulEatingMagicWeaponImpl getImp() {
        return (SoulEatingMagicWeaponImpl) imp;
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

    public void eatSoul() {
        getImp().eatSoulImp();
    }
}
