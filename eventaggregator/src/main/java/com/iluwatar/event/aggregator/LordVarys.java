package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public class LordVarys extends EventEmitter {

    public LordVarys() {
        super();
    }

    public LordVarys(EventObserver obs) {
        super(obs);
    }

    @Override
    public void timePassed(Weekday weekday) {
        if (weekday.equals(Weekday.SATURDAY)) {
            notifyObservers(Event.TRAITOR_DETECTED);
        }
    }
}
