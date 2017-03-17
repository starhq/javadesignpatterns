package com.iluwatar.async.method.invocation;

import java.util.concurrent.ExecutionException;

/**
 * Created by starhq on 2017/3/17.
 */
public interface AsyncResult<T> {

    boolean isComplete();

    T getValue() throws ExecutionException;

    void await() throws InterruptedException;
}
