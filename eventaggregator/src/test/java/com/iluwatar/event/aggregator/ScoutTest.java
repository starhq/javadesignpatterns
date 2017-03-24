package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public class ScoutTest extends EventEmitterTest<Scout> {

    /**
     * Create a new test instance, using the correct object factory
     */
    public ScoutTest() {
        super(Weekday.TUESDAY, Event.WARSHIPS_APPROACHING, Scout::new, Scout::new);
    }

}

