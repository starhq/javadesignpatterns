package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public enum Event {

    STARK_SIGHTED("Stark sighted"), WARSHIPS_APPROACHING("Warships approaching"), TRAITOR_DETECTED(
            "Traitor detected");

    private String description;

    Event(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
