package com.iluwatar.flux.action;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by starhq on 2017/4/1.
 */
public class MenuItemTest {

    @Test
    public void testToString() throws Exception {
        for (final MenuItem menuItem : MenuItem.values()) {
            final String toString = menuItem.toString();
            assertNotNull(toString);
            assertFalse(toString.trim().isEmpty());
        }
    }
}
