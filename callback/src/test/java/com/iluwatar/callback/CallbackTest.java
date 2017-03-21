package com.iluwatar.callback;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by starhq on 2017/3/21.
 */
public class CallbackTest {

    private Integer callingCount = 0;

    @Test
    public void test() {
        Callback callback = new Callback() {
            @Override
            public void call() {
                callingCount++;
            }
        };

        Task task = new SimpleTask();

        assertEquals("Initial calling count of 0", new Integer(0), callingCount);

        task.executeWith(callback);

        assertEquals("Callback called once", new Integer(1), callingCount);

        task.executeWith(callback);

        assertEquals("Callback called twice", new Integer(2), callingCount);

    }

    @Test
    public void testWithLambdasExample() {
        Callback callback = () -> callingCount++;

        Task task = new SimpleTask();

        assertEquals("Initial calling count of 0", new Integer(0), callingCount);

        task.executeWith(callback);

        assertEquals("Callback called once", new Integer(1), callingCount);

        task.executeWith(callback);

        assertEquals("Callback called twice", new Integer(2), callingCount);

    }
}
