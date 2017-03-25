package com.iluwatar.factorykit;

import java.util.function.Supplier;

/**
 * Created by starhq on 2017/3/25.
 */
public interface Builder {

    void add(WeaponType name, Supplier<Weapon> supplier);
}
