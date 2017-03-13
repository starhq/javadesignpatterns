package com.iluwatar.adapter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Captain captain = new Captain(new BattleFishingBoat());
        captain.move();
        captain.fire();
    }
}
