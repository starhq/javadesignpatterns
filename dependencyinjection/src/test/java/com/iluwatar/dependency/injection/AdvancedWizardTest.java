package com.iluwatar.dependency.injection;

import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by starhq on 2017/3/24.
 */
public class AdvancedWizardTest extends StdOutTest {

    @Test
    public void testSmokeEveryThing() throws Exception {

        final Tobacco[] tobaccos = {
                new OldTobyTobacco(), new RivendellTobacco(), new SecondBreakfastTobacco()
        };

        for (final Tobacco tobacco : tobaccos) {
            final AdvancedWizard advancedWizard = new AdvancedWizard(tobacco);
            advancedWizard.smoke();

            // Verify if the wizard is smoking the correct tobacco ...
            verify(getStdOutMock(), times(1)).println("AdvancedWizard smoking " + tobacco.getClass().getSimpleName());

            // ... and nothing else is happening.
            verifyNoMoreInteractions(getStdOutMock());
        }

    }
}
