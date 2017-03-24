package com.iluwatar.event.aggregator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by starhq on 2017/3/24.
 */
public class EventTest {

    @Test
    public void testToString() {
        for (final Event event : Event.values()) {
            final String toString = event.toString();
            assertNotNull(toString);
            assertFalse(toString.trim().isEmpty());
        }
    }
}
