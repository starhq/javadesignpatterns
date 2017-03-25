package com.iluwatar.factory.method;

/**
 * Created by starhq on 2017/3/25.
 */
public enum WeaponType {

    SHORT_SWORD("short sword"), SPEAR("spear"), AXE("axe"), UNDEFINED("");

    private String title;

    WeaponType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
