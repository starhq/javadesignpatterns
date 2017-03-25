package com.iluwatar.eda.handler;

import com.iluwatar.eda.event.UserCreatedEvent;
import com.iluwatar.eda.framework.Handler;

/**
 * Created by starhq on 2017/3/25.
 */
public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {
    @Override
    public void onEvent(UserCreatedEvent event) {
        System.out.println(String.format(
                "User '%s' has been Created!", event.getUser().getUsername()));
    }
}
