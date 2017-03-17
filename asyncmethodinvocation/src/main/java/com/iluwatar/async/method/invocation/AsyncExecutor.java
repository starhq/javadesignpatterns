package com.iluwatar.async.method.invocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by starhq on 2017/3/17.
 */
public interface AsyncExecutor {

    <T> AsyncResult<T> startProcess(Callable<T> task);

    <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback);

    <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException;
}
