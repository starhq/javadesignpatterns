package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public class Scout extends EventEmitter {

    public Scout() {
    }

    public Scout(EventObserver obs) {
        super(obs);
    }

    @Override
    public void timePassed(Weekday weekday) {
        if (weekday.equals(Weekday.TUESDAY)) {
            notifyObservers(Event.WARSHIPS_APPROACHING);
        }
    }
}
