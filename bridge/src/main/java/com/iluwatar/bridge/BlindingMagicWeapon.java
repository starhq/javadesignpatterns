package com.iluwatar.bridge;

/**
 * Created by starhq on 2017/3/20.
 */
public class BlindingMagicWeapon extends MagicWeapon {

    public BlindingMagicWeapon(BlindingMagicWeaponImpl imp) {
        super(imp);
    }

    @Override
    public BlindingMagicWeaponImpl getImp() {
        return (BlindingMagicWeaponImpl) imp;
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

    public void blind() {
        getImp().blindImp();
    }
}
