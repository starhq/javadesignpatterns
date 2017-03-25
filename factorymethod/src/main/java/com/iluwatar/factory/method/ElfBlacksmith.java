package com.iluwatar.factory.method;

/**
 * Created by starhq on 2017/3/25.
 */
public class ElfBlacksmith implements Blacksmith {
    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return new ElfWeapon(weaponType);
    }
}
