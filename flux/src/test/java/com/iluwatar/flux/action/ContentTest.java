package com.iluwatar.flux.action;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by starhq on 2017/4/1.
 */
public class ContentTest {

    @Test
    public void testToString() throws Exception {
        for (final Content content : Content.values()) {
            final String toString = content.toString();
            assertNotNull(toString);
            assertFalse(toString.trim().isEmpty());
        }
    }
}
