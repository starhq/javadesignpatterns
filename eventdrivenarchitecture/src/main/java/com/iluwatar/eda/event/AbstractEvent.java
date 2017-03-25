package com.iluwatar.eda.event;

import com.iluwatar.eda.framework.Event;

/**
 * Created by starhq on 2017/3/25.
 */
public abstract class AbstractEvent implements Event {

    public Class<? extends Event> getType() {
        return getClass();
    }
}
