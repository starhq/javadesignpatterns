package com.iluwatar.decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by starhq on 2017/3/23.
 */
public class SmartHostileTest {

    @Test
    public void testSmartHostile() throws Exception {
        // Create a normal troll first, but make sure we can spy on it later on.
        final Hostile simpleTroll = spy(new Troll());

        // Now we want to decorate the troll to make it smarter ...
        final Hostile smartTroll = new SmartHostile(simpleTroll);
        assertEquals(30, smartTroll.getAttackPower());
        verify(simpleTroll, times(1)).getAttackPower();

        // Check if the smart troll actions are delegated to the decorated troll
        smartTroll.attack();
        verify(simpleTroll, times(1)).attack();

        smartTroll.fleeBattle();
        verify(simpleTroll, times(1)).fleeBattle();
        verifyNoMoreInteractions(simpleTroll);

    }
}
