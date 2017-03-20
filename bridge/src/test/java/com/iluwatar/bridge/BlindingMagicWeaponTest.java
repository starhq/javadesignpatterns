package com.iluwatar.bridge;

import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by starhq on 2017/3/20.
 */
public class BlindingMagicWeaponTest extends MagicWeaponTest {

    /**
     * Invoke all possible actions on the weapon and check if the actions are executed on the actual
     * underlying weapon implementation.
     */
    @Test
    public void testExcalibur() throws Exception {
        final Excalibur excalibur = spy(new Excalibur());
        final BlindingMagicWeapon blindingMagicWeapon = new BlindingMagicWeapon(excalibur);

        testBasicWeaponActions(blindingMagicWeapon, excalibur);

        blindingMagicWeapon.blind();
        verify(excalibur, times(1)).blindImp();
        verifyNoMoreInteractions(excalibur);
    }

}

