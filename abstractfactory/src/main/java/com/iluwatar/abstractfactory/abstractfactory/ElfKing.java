package com.iluwatar.abstractfactory.abstractfactory;

/**
 * Created by starhq on 2017/3/10.
 */
public class ElfKing implements King {
    public static final String DESCRIPTION = "This is the Elven king!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
