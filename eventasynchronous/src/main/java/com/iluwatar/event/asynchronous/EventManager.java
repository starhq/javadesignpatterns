package com.iluwatar.event.asynchronous;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by starhq on 2017/3/27.
 */
public class EventManager implements ThreadCompleteListener {

    public static final int MAX_RUNNING_EVENTS = 1000;
    public static final int MIN_ID = 1;
    public static final int MAX_ID = MAX_RUNNING_EVENTS;
    public static final int MAX_EVENT_TIME = 1800;

    private int currentlyRunningSyncEvent = -1;
    private Random rand;
    private Map<Integer, Event> eventPool;

    public EventManager() {
        rand = new Random(1);
        eventPool = new ConcurrentHashMap<>(MAX_RUNNING_EVENTS);
    }

    public int create(int eventTime) throws InvalidOperationException, LongRunningEventException,
            MaxNumOfEventsAllowedException {
        if (currentlyRunningSyncEvent != -1) {
            throw new InvalidOperationException(
                    "Event [" + currentlyRunningSyncEvent + "] is still running. Please wait until it finishes and " +
                            "try again.");
        }

        int eventId = createEvent(eventTime, true);
        currentlyRunningSyncEvent = eventId;
        return eventId;
    }

    public int createAsync(int eventTime) throws LongRunningEventException, MaxNumOfEventsAllowedException {
        return createEvent(eventTime, false);
    }

    private int createEvent(int eventTime, boolean isSynchronous) throws LongRunningEventException,
            MaxNumOfEventsAllowedException {
        if (eventPool.size() == MAX_RUNNING_EVENTS) {
            throw new MaxNumOfEventsAllowedException("Too many events are running at the moment. Please try again " +
                    "later.");
        }

        if (eventTime >= MAX_EVENT_TIME) {
            throw new LongRunningEventException(
                    "Maximum event time allowed is " + MAX_EVENT_TIME + " seconds. Please try again.");
        }

        int newEventId = generateId();

        Event newEvent = new Event(newEventId, eventTime, isSynchronous);
        newEvent.addListener(this);
        eventPool.put(newEventId, newEvent);
        return newEventId;
    }

    public void start(int eventId) throws EventDoesNotExistException {
        if (!eventPool.containsKey(eventId)) {
            throw new EventDoesNotExistException(eventId + " does not exist.");
        }

        eventPool.get(eventId).start();
    }


    public void cancel(int eventId) throws EventDoesNotExistException {
        if (!eventPool.containsKey(eventId)) {
            throw new EventDoesNotExistException(eventId + " does not exist.");
        }

        if (eventId == currentlyRunningSyncEvent) {
            currentlyRunningSyncEvent = -1;
        }

        eventPool.get(eventId).stop();
        eventPool.remove(eventId);
    }

    public void status(int eventId) throws EventDoesNotExistException {
        if (!eventPool.containsKey(eventId)) {
            throw new EventDoesNotExistException(eventId + " does not exist.");
        }
        eventPool.get(eventId).status();
    }

    public void statusOfAllEvents() {
        Iterator<Map.Entry<Integer, Event>> it = eventPool.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Event> pair = it.next();
            pair.getValue().status();
        }
    }

    public void shutdown() {
        Iterator<Map.Entry<Integer, Event>> it = eventPool.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Event> pair = it.next();
            pair.getValue().stop();
        }
    }

    private int generateId() {
        int randomNum = rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        while (eventPool.containsKey(randomNum)) {
            randomNum = rand.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        }
        return randomNum;
    }

    @Override
    public void completedEventHandler(int eventId) {

    }

    public Map<Integer, Event> getEventPool() {
        return eventPool;
    }

    public int numOfCurrentlyRunningSyncEvent() {
        return currentlyRunningSyncEvent;
    }
}
