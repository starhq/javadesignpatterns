package com.iluwatar.facade;

/**
 * Created by starhq on 2017/3/25.
 */
public class DwarvenGoldDigger extends DwarvenMineWorker {
    @Override
    public void work() {
        System.out.println(name() + " digs for gold.");
    }

    @Override
    public String name() {
        return "Dwarf gold digger";
    }
}
