package com.iluwatar.doubledispatch;

import org.junit.After;
import org.junit.Before;

import java.io.PrintStream;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by starhq on 2017/3/24.
 */
public abstract class CollisionTest<O extends GameObject> {

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

    /**
     * Get the mocked stdOut {@link PrintStream}
     *
     * @return The stdOut print stream mock, renewed before each test
     */
    final PrintStream getStdOutMock() {
        return this.stdOutMock;
    }

    /**
     * Get the tested object
     *
     * @return The tested object, should never return 'null'
     */
    abstract O getTestedObject();

    /**
     * Collide the tested item with the other given item and verify if the damage and fire state is as
     * expected
     *
     * @param other        The other object we have to collide with
     * @param otherDamaged Indicates if the other object should be damaged after the collision
     * @param otherOnFire  Indicates if the other object should be burning after the collision
     * @param thisDamaged  Indicates if the test object should be damaged after the collision
     * @param thisOnFire   Indicates if the other object should be burning after the collision
     * @param description  The expected description of the collision
     */
    void testCollision(final GameObject other, final boolean otherDamaged, final boolean otherOnFire,
                       final boolean thisDamaged, final boolean thisOnFire, final String description) {

        Objects.requireNonNull(other);
        Objects.requireNonNull(getTestedObject());

        final O tested = getTestedObject();

        tested.collision(other);

        verify(getStdOutMock(), times(1)).println(description);
        verifyNoMoreInteractions(getStdOutMock());

        testOnFire(other, tested, otherOnFire);
        testDamaged(other, tested, otherDamaged);

        testOnFire(tested, other, thisOnFire);
        testDamaged(tested, other, thisDamaged);

    }

    /**
     * Test if the fire state of the target matches the expected state after colliding with the given
     * object
     *
     * @param target             The target object
     * @param other              The other object
     * @param expectTargetOnFire The expected state of fire on the target object
     */
    private void testOnFire(final GameObject target, final GameObject other, final boolean expectTargetOnFire) {
        final String targetName = target.getClass().getSimpleName();
        final String otherName = other.getClass().getSimpleName();

        final String errorMessage = expectTargetOnFire
                ? "Expected [" + targetName + "] to be on fire after colliding with [" + otherName + "] but it was not!"
                : "Expected [" + targetName + "] not to be on fire after colliding with [" + otherName + "] but it " +
                "was!";

        assertEquals(errorMessage, expectTargetOnFire, target.isOnFire());
    }

    /**
     * Test if the damage state of the target matches the expected state after colliding with the
     * given object
     *
     * @param target         The target object
     * @param other          The other object
     * @param expectedDamage The expected state of damage on the target object
     */
    private void testDamaged(final GameObject target, final GameObject other, final boolean expectedDamage) {
        final String targetName = target.getClass().getSimpleName();
        final String otherName = other.getClass().getSimpleName();

        final String errorMessage = expectedDamage
                ? "Expected [" + targetName + "] to be damaged after colliding with [" + otherName + "] but it was not!"
                : "Expected [" + targetName + "] not to be damaged after colliding with [" + otherName + "] but it " +
                "was!";

        assertEquals(errorMessage, expectedDamage, target.isDamaged());
    }
}
