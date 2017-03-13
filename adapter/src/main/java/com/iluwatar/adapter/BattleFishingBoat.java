package com.iluwatar.adapter;

/**
 * Created by starhq on 2017/3/10.
 */
public class BattleFishingBoat implements BattleShip {

    private FishingBoat boat;

    public BattleFishingBoat() {
        this.boat = new FishingBoat();
    }

    @Override
    public void fire() {
        System.out.println("fire!");
    }

    @Override
    public void move() {
        boat.sail();
    }
}
