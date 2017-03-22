package com.iluwatar.command;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by starhq on 2017/3/22.
 */
public class CommandTest {

    private static final String GOBLIN = "Goblin";

    /**
     * This test verifies that when the wizard casts spells on the goblin. The wizard keeps track of
     * the previous spells cast, so it is easy to undo them. In addition, it also verifies that the
     * wizard keeps track of the spells undone, so they can be redone.
     */
    @Test
    public void testCommand() {

        Wizard wizard = new Wizard();
        Goblin goblin = new Goblin();

        wizard.castSpell(new ShrinkSpell(), goblin);
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.VISIBLE);

        wizard.castSpell(new InvisibilitySpell(), goblin);
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.INVISIBLE);

        wizard.undoLast();
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.VISIBLE);

        wizard.undoLast();
        verifyGoblin(goblin, GOBLIN, Size.NORMAL, Visibility.VISIBLE);

        wizard.redoLast();
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.VISIBLE);

        wizard.redoLast();
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.INVISIBLE);
    }

    /**
     * This method asserts that the passed goblin object has the name as expectedName, size as
     * expectedSize and visibility as expectedVisibility.
     *
     * @param goblin            a goblin object whose state is to be verified against other parameters
     * @param expectedName      expectedName of the goblin
     * @param expectedSize      expected size of the goblin
     * @param expectedVisibilty exepcted visibility of the goblin
     */
    private void verifyGoblin(Goblin goblin, String expectedName, Size expectedSize,
                              Visibility expectedVisibilty) {
        assertEquals("Goblin's name must be same as expectedName", expectedName, goblin.toString());
        assertEquals("Goblin's size must be same as expectedSize", expectedSize, goblin.getSize());
        assertEquals("Goblin's visibility must be same as expectedVisibility", expectedVisibilty,
                goblin.getVisibility());
    }
}
