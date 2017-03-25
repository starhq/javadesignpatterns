package com.iluwatar.factory.method;

/**
 * Created by starhq on 2017/3/25.
 */
public class OrcWeapon implements Weapon {

    private WeaponType weaponType;

    public OrcWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return "Orcish " + weaponType;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }
}
