package com.iluwatar.decorator;

/**
 * Created by starhq on 2017/3/23.
 */
public class SmartHostile implements Hostile {

    private Hostile decorated;

    public SmartHostile(Hostile decorated) {
        this.decorated = decorated;
    }

    @Override
    public void attack() {
        System.out.println("It throws a rock at you!");
        decorated.attack();
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower() + 20;
    }

    @Override
    public void fleeBattle() {
        System.out.println("It calls for help!");
        decorated.fleeBattle();
    }
}
