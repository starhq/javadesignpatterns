package com.iluwatar.event.aggregator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by starhq on 2017/3/24.
 */
public abstract class EventEmitter {

    private List<EventObserver> observers;

    public EventEmitter() {
        observers = new LinkedList<>();
    }

    public EventEmitter(EventObserver obs) {
        this();
        registerObserver(obs);
    }

    public final void registerObserver(EventObserver observer) {
        observers.add(observer);
    }

    protected void notifyObservers(Event e) {
        for (EventObserver obs : observers) {
            obs.onEvent(e);
        }
    }

    public abstract void timePassed(Weekday weekday);


}
