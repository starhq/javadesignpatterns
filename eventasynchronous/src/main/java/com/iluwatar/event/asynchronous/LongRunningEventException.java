package com.iluwatar.event.asynchronous;

/**
 * Created by starhq on 2017/3/27.
 */
public class LongRunningEventException extends Throwable {


    private static final long serialVersionUID = -6632095798621469562L;

    public LongRunningEventException(String s) {
        super(s);
    }
}
