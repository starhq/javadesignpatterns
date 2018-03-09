package com.iluwatar.templatemethod;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class HalflingThiefTest {

    @Test
    public void testSteal() {
        final StealingMethod method = mock(StealingMethod.class);
        final HalflingThief thief = new HalflingThief(method);

        thief.steal();
        verify(method).steal();

        verifyNoMoreInteractions(method);
    }

    /**
     * Verify if the thief uses the provided stealing method, and the new method after changing it
     */
    @Test
    public void testChangeMethod() {
        final StealingMethod initialMethod = mock(StealingMethod.class);
        final HalflingThief thief = new HalflingThief(initialMethod);

        thief.steal();
        verify(initialMethod).steal();

        final StealingMethod newMethod = mock(StealingMethod.class);
        thief.changeMethod(newMethod);

        thief.steal();
        verify(newMethod).steal();

        verifyNoMoreInteractions(initialMethod, newMethod);

    }
}
