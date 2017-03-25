package com.iluwatar.factory.method;

/**
 * Created by starhq on 2017/3/25.
 */
public class ElfWeapon implements Weapon {

    private WeaponType weaponType;

    public ElfWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return "Elven " + weaponType;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }
}
