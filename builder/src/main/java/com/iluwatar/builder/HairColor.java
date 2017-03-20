package com.iluwatar.builder;

/**
 * Created by starhq on 2017/3/20.
 */
public enum HairColor {

    WHITE, BLOND, RED, BROWN, BLACK;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
