package com.iluwatar.event.aggregator;

/**
 * Created by starhq on 2017/3/24.
 */
public class LordBaelishTest extends EventEmitterTest<LordBaelish> {

    /**
     * Create a new test instance, using the correct object factory
     */
    public LordBaelishTest() {
        super(Weekday.FRIDAY, Event.STARK_SIGHTED, LordBaelish::new, LordBaelish::new);
    }

}
