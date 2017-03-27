package com.iluwatar.event.asynchronous;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by starhq on 2017/3/27.
 */
public class EventAsynchronousTest {

    App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testAsynchronousEvent() {
        EventManager eventManager = new EventManager();
        try {
            int aEventId = eventManager.createAsync(60);
            eventManager.start(aEventId);
            assertTrue(eventManager.getEventPool().size() == 1);
            assertTrue(eventManager.getEventPool().size() < EventManager.MAX_RUNNING_EVENTS);
            assertTrue(eventManager.numOfCurrentlyRunningSyncEvent() == -1);
            eventManager.cancel(aEventId);
            assertTrue(eventManager.getEventPool().size() == 0);
        } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSynchronousEvent() {
        EventManager eventManager = new EventManager();
        try {
            int sEventId = eventManager.create(60);
            eventManager.start(sEventId);
            assertTrue(eventManager.getEventPool().size() == 1);
            assertTrue(eventManager.getEventPool().size() < EventManager.MAX_RUNNING_EVENTS);
            assertTrue(eventManager.numOfCurrentlyRunningSyncEvent() != -1);
            eventManager.cancel(sEventId);
            assertTrue(eventManager.getEventPool().size() == 0);
        } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException
                | InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test(expected = InvalidOperationException.class)
    public void testUnsuccessfulSynchronousEvent() throws InvalidOperationException {
        EventManager eventManager = new EventManager();
        try {
            int sEventId = eventManager.create(60);
            eventManager.start(sEventId);
            sEventId = eventManager.create(60);
            eventManager.start(sEventId);
        } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFullSynchronousEvent() {
        EventManager eventManager = new EventManager();
        try {
            int eventTime = 1;

            int sEventId = eventManager.create(eventTime);
            assertTrue(eventManager.getEventPool().size() == 1);
            eventManager.start(sEventId);

            long currentTime = System.currentTimeMillis();
            long endTime = currentTime + (eventTime + 2 * 1000); // +2 to give a bit of buffer time for event to
            // complete
            // properly.
            while (System.currentTimeMillis() < endTime) {
            }

            assertTrue(eventManager.getEventPool().size() == 0);

        } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException
                | InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFullAsynchronousEvent() {
        EventManager eventManager = new EventManager();
        try {
            int eventTime = 1;

            int aEventId1 = eventManager.createAsync(eventTime);
            int aEventId2 = eventManager.createAsync(eventTime);
            int aEventId3 = eventManager.createAsync(eventTime);
            assertTrue(eventManager.getEventPool().size() == 3);

            eventManager.start(aEventId1);
            eventManager.start(aEventId2);
            eventManager.start(aEventId3);

            long currentTime = System.currentTimeMillis();
            long endTime = currentTime + (eventTime + 2 * 1000); // +2 to give a bit of buffer time for event to
            // complete
            // properly.
            while (System.currentTimeMillis() < endTime) {
            }

            assertTrue(eventManager.getEventPool().size() == 0);

        } catch (MaxNumOfEventsAllowedException | LongRunningEventException | EventDoesNotExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
