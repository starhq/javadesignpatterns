package com.iluwatar.factory.method;

/**
 * Created by starhq on 2017/3/25.
 */
public class OrcBlacksmith implements Blacksmith {


    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return new OrcWeapon(weaponType);
    }
}
