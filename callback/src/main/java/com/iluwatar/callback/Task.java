package com.iluwatar.callback;

/**
 * Created by starhq on 2017/3/21.
 */
public abstract class Task {

    public final void executeWith(Callback callback) {
        execute();
        if (callback != null) {
            callback.call();
        }
    }

    public abstract void execute();
}
