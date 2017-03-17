package com.iluwatar.async.method.invocation;

import java.util.Optional;

/**
 * Created by starhq on 2017/3/17.
 */
public interface AsyncCallback<T> {

    void onComplete(T value, Optional<Exception> ex);
}
