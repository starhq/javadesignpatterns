package com.iluwatar.event.asynchronous;

/**
 * Created by starhq on 2017/3/27.
 */
public class Event implements IEvent, Runnable {

    private int eventId;
    private int eventTime;
    private boolean isSynchronous;
    private Thread thread;
    private boolean isComplete = false;
    private ThreadCompleteListener eventListener;

    public Event(int eventId, int eventTime, boolean isSynchronous) {
        this.eventId = eventId;
        this.eventTime = eventTime;
        this.isSynchronous = isSynchronous;
    }

    public boolean isSynchronous() {
        return isSynchronous;
    }

    @Override
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        if (null == thread) {
            return;
        }
        thread.interrupt();
    }

    @Override
    public void status() {
        if (!isComplete) {
            System.out.println("[" + eventId + "] is not done.");
        } else {
            System.out.println("[" + eventId + "] is done.");
        }
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        long entTime = currentTime + (eventTime * 1000);
        while (System.currentTimeMillis() < entTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isComplete = true;
        completed();
    }

    public final void addListener(final ThreadCompleteListener listener) {
        this.eventListener = listener;
    }

    public final void removeListener(final ThreadCompleteListener listener) {
        this.eventListener = null;
    }


    private final void completed() {
        if (eventListener != null) {
            eventListener.completedEventHandler(eventId);
        }
    }
}
