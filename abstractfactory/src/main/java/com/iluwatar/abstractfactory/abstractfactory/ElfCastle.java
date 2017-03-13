package com.iluwatar.abstractfactory.abstractfactory;

/**
 * Created by starhq on 2017/3/10.
 */
public class ElfCastle implements Castle {
    public static final String DESCRIPTION = "This is the Elven castle!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
