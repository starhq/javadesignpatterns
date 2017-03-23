package com.iluwatar.decorator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;


/**
 * Created by starhq on 2017/3/23.
 */
public class TrollTest {

    private final PrintStream stdOutMock = mock(PrintStream.class);

    /**
     * Keep the original std-out so it can be restored after the test
     */
    private final PrintStream stdOutOrig = System.out;

    /**
     * Inject the mocked std-out {@link PrintStream} into the {@link System} class before each test
     */
    @Before
    public void setUp() {
        System.setOut(this.stdOutMock);
    }

    /**
     * Removed the mocked std-out {@link PrintStream} again from the {@link System} class
     */
    @After
    public void tearDown() {
        System.setOut(this.stdOutOrig);
    }

    @Test
    public void testTrollActions() throws Exception {
        final Troll troll = new Troll();
        assertEquals(10, troll.getAttackPower());

        troll.attack();
        verify(this.stdOutMock, times(1)).println(eq("The troll swings at you with a club!"));

        troll.fleeBattle();
        verify(this.stdOutMock, times(1)).println(eq("The troll shrieks in horror and runs away!"));

        verifyNoMoreInteractions(this.stdOutMock);
    }
}
