package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public class KingJoffrey implements EventObserver {
    @Override
    public void onEvent(Event e) {
        System.out.println("Received event from the King's Hand: " + e.toString());
    }
}
