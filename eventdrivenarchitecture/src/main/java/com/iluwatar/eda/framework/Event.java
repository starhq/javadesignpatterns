package com.iluwatar.eda.framework;

/**
 * Created by starhq on 2017/3/25.
 */
public interface Event {

    Class<? extends Event> getType();
}
