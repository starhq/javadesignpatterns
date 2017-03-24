package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public class LordBaelish extends EventEmitter {

    public LordBaelish() {
    }

    public LordBaelish(EventObserver obs) {
        super(obs);
    }

    @Override
    public void timePassed(Weekday weekday) {
        if (weekday.equals(Weekday.FRIDAY)) {
            notifyObservers(Event.STARK_SIGHTED);
        }
    }
}
