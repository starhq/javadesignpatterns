package com.iluwatar.abstractfactory.abstractfactory;

/**
 * Created by starhq on 2017/3/10.
 */
public class ElfArmy implements Army {
    public static final String DESCRIPTION = "This is the Elven Army!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
