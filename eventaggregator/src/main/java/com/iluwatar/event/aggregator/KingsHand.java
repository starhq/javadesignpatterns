package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public class KingsHand extends EventEmitter implements EventObserver {

    public KingsHand() {
        super();
    }

    public KingsHand(EventObserver obs) {
        super(obs);
    }

    @Override
    public void onEvent(Event e) {
        notifyObservers(e);
    }

    @Override
    public void timePassed(Weekday weekday) {

    }
}
