package com.iluwatar.event.asynchronous;

/**
 * Created by starhq on 2017/3/27.
 */
public class EventDoesNotExistException extends Throwable {


    private static final long serialVersionUID = -3398463738273811509L;

    public EventDoesNotExistException(String s) {
        super(s);
    }
}
