package com.iluwatar.bridge;

/**
 * Created by starhq on 2017/3/20.
 */
public abstract class MagicWeapon {

    protected MagicWeaponImpl imp;

    public MagicWeapon(MagicWeaponImpl imp) {
        this.imp = imp;
    }

    public abstract void wield();

    public abstract void swing();

    public abstract void unwield();

    public MagicWeaponImpl getImp() {
        return imp;
    }
}
