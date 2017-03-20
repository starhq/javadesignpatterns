package com.iluwatar.bridge;

import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by starhq on 2017/3/20.
 */
public class FlyingMagicWeaponTest extends MagicWeaponTest {

    @Test
    public void testMjollnir() throws Exception {
        final Mjollnir mjollnir = spy(new Mjollnir());
        final FlyingMagicWeapon flyingMagicWeapon = new FlyingMagicWeapon(mjollnir);

        testBasicWeaponActions(flyingMagicWeapon, mjollnir);

        flyingMagicWeapon.fly();
        verify(mjollnir, times(1)).flyImp();
        verifyNoMoreInteractions(mjollnir);
    }
}
