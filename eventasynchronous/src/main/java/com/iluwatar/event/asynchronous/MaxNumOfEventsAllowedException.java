package com.iluwatar.event.asynchronous;

/**
 * Created by starhq on 2017/3/27.
 */
public class MaxNumOfEventsAllowedException extends Throwable {


    private static final long serialVersionUID = -8430876973516292695L;

    public MaxNumOfEventsAllowedException(String s) {
        super(s);
    }
}
