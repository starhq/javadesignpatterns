package com.iluwatar.eda.event;

import com.iluwatar.eda.model.User;

/**
 * Created by starhq on 2017/3/25.
 */
public class UserUpdatedEvent extends AbstractEvent {

    private User user;

    public UserUpdatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
