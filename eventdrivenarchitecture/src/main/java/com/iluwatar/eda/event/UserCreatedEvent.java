package com.iluwatar.eda.event;

import com.iluwatar.eda.model.User;

/**
 * Created by starhq on 2017/3/25.
 */
public class UserCreatedEvent extends AbstractEvent {

    private User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
