package com.iluwatar.builder;

/**
 * Created by starhq on 2017/3/20.
 */
public enum Profession {

    WARRIOR, THIEF, MAGE, PRIEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
