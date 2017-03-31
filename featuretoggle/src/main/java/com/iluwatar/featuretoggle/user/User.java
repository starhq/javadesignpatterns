package com.iluwatar.featuretoggle.user;

/**
 * Created by starhq on 2017/3/31.
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
