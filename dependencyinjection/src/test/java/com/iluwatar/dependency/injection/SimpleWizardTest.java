package com.iluwatar.dependency.injection;

import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by starhq on 2017/3/24.
 */
public class SimpleWizardTest extends StdOutTest {

    @Test
    public void testSmoke() {
        final SimpleWizard simpleWizard = new SimpleWizard();
        simpleWizard.smoke();
        verify(getStdOutMock(), times(1)).println("SimpleWizard smoking OldTobyTobacco");
        verifyNoMoreInteractions(getStdOutMock());
    }
}
