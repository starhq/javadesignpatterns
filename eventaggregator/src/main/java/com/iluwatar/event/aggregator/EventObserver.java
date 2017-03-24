package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public interface EventObserver {

    void onEvent(Event e);
}
