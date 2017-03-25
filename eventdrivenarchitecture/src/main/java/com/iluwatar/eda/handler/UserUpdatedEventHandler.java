package com.iluwatar.eda.handler;

import com.iluwatar.eda.event.UserUpdatedEvent;
import com.iluwatar.eda.framework.Handler;

/**
 * Created by starhq on 2017/3/25.
 */
public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {
    @Override
    public void onEvent(UserUpdatedEvent event) {
        System.out.println(String.format(
                "User '%s' has been Updated!", event.getUser().getUsername()));
    }
}
