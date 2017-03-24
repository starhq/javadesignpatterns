package com.iluwatar.doubledispatch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by starhq on 2017/3/24.
 */
public class FlamingAsteroidTest extends CollisionTest<FlamingAsteroid> {

    @Override
    final FlamingAsteroid getTestedObject() {
        return new FlamingAsteroid(1, 2, 3, 4);
    }

    /**
     * Test the constructor parameters
     */
    @Test
    public void testConstructor() {
        final FlamingAsteroid asteroid = new FlamingAsteroid(1, 2, 3, 4);
        assertEquals(1, asteroid.getLeft());
        assertEquals(2, asteroid.getTop());
        assertEquals(3, asteroid.getRight());
        assertEquals(4, asteroid.getBottom());
        assertTrue(asteroid.isOnFire());
        assertFalse(asteroid.isDamaged());
        assertEquals("FlamingAsteroid at [1,2,3,4] damaged=false onFire=true", asteroid.toString());
    }

    /**
     * Test what happens we collide with an asteroid
     */
    @Test
    public void testCollideFlamingAsteroid() {
        testCollision(
                new FlamingAsteroid(1, 2, 3, 4),
                false, true,
                false, true,
                "FlamingAsteroid hits FlamingAsteroid."
        );
    }

    /**
     * Test what happens we collide with an meteoroid
     */
    @Test
    public void testCollideMeteoroid() {
        testCollision(
                new Meteoroid(1, 1, 3, 4),
                false, false,
                false, true,
                "FlamingAsteroid hits Meteoroid."
        );
    }

    /**
     * Test what happens we collide with ISS
     */
    @Test
    public void testCollideSpaceStationIss() {
        testCollision(
                new SpaceStationIss(1, 1, 3, 4),
                true, true,
                false, true,
                "FlamingAsteroid hits SpaceStationIss. SpaceStationIss is damaged! SpaceStationIss is set on fire!"
        );
    }

    /**
     * Test what happens we collide with MIR
     */
    @Test
    public void testCollideSpaceStationMir() {
        testCollision(
                new SpaceStationMir(1, 1, 3, 4),
                true, true,
                false, true,
                "FlamingAsteroid hits SpaceStationMir. SpaceStationMir is damaged! SpaceStationMir is set on fire!"
        );
    }
}
