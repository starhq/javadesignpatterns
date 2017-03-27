package com.iluwatar.event.asynchronous;

/**
 * Created by starhq on 2017/3/27.
 */
public class InvalidOperationException extends Throwable {
    private static final long serialVersionUID = -6191545255213410803L;

    public InvalidOperationException(String message) {
        super(message);
    }
}
