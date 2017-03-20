package com.iluwatar.bridge;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by starhq on 2017/3/20.
 */
public abstract class MagicWeaponTest {

    protected final void testBasicWeaponActions(final MagicWeapon weapon,
                                                final MagicWeaponImpl weaponImpl) {
        assertNotNull(weapon);
        assertNotNull(weaponImpl);
        assertNotNull(weapon.getImp());

        weapon.swing();
        verify(weaponImpl, times(1)).swingImp();
        verifyNoMoreInteractions(weaponImpl);

        weapon.wield();
        verify(weaponImpl, times(1)).weidImp();
        verifyNoMoreInteractions(weaponImpl);

        weapon.unwield();
        verify(weaponImpl, times(1)).unweidImp();
        verifyNoMoreInteractions(weaponImpl);

    }
}
