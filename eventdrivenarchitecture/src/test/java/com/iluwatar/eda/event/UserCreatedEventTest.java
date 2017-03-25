package com.iluwatar.eda.event;

import com.iluwatar.eda.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by starhq on 2017/3/25.
 */
public class UserCreatedEventTest {

    @Test
    public void testGetEventType() {
        User user = new User("iluwatar");
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
        assertEquals(UserCreatedEvent.class, userCreatedEvent.getType());
    }
}
