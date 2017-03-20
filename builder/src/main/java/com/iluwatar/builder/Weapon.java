package com.iluwatar.builder;

/**
 * Created by starhq on 2017/3/20.
 */
public enum Weapon {

    DAGGER, SWORD, AXE, WARHAMMER, BOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
