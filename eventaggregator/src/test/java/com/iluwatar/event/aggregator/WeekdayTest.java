package com.iluwatar.event.aggregator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by starhq on 2017/3/24.
 */
public class WeekdayTest {

    @Test
    public void testToString() throws Exception {
        for (final Weekday weekday : Weekday.values()) {
            final String toString = weekday.toString();
            assertNotNull(toString);
            assertEquals(weekday.name(), toString.toUpperCase());
        }
    }
}
