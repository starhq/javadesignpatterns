package com.iluwatar.eda.framework;

import com.iluwatar.eda.event.UserCreatedEvent;
import com.iluwatar.eda.event.UserUpdatedEvent;
import com.iluwatar.eda.handler.UserCreatedEventHandler;
import com.iluwatar.eda.handler.UserUpdatedEventHandler;
import com.iluwatar.eda.model.User;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by starhq on 2017/3/25.
 */
public class EventDispatcherTest {

    @Test
    public void testEventDriverPattern() {

        EventDispatcher dispatcher = spy(new EventDispatcher());
        UserCreatedEventHandler userCreatedEventHandler = spy(new UserCreatedEventHandler());
        UserUpdatedEventHandler userUpdatedEventHandler = spy(new UserUpdatedEventHandler());
        dispatcher.registerHandler(UserCreatedEvent.class, userCreatedEventHandler);
        dispatcher.registerHandler(UserUpdatedEvent.class, userUpdatedEventHandler);

        User user = new User("iluwatar");

        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
        UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent(user);

        //fire a userCreatedEvent and verify that userCreatedEventHandler has been invoked.
        dispatcher.dispatch(userCreatedEvent);
        verify(userCreatedEventHandler).onEvent(userCreatedEvent);
        verify(dispatcher).dispatch(userCreatedEvent);

        //fire a userCreatedEvent and verify that userUpdatedEventHandler has been invoked.
        dispatcher.dispatch(userUpdatedEvent);
        verify(userUpdatedEventHandler).onEvent(userUpdatedEvent);
        verify(dispatcher).dispatch(userUpdatedEvent);
    }
}
