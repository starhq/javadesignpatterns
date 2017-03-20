package com.iluwatar.bridge;

import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by starhq on 2017/3/20.
 */
public class SoulEatingMagicWeaponTest extends MagicWeaponTest {

    @Test
    public void testStormBringer() throws Exception {
        final Stormbringer stormbringer = spy(new Stormbringer());
        final SoulEatingMagicWeapon soulEatingMagicWeapon = new SoulEatingMagicWeapon(stormbringer);

        testBasicWeaponActions(soulEatingMagicWeapon, stormbringer);

        soulEatingMagicWeapon.eatSoul();
        verify(stormbringer, times(1)).eatSoulImp();
        verifyNoMoreInteractions(stormbringer);
    }
}
