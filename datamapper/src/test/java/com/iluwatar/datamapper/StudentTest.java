package com.iluwatar.datamapper;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by starhq on 2017/3/23.
 */
public class StudentTest {

    @Test
    /**
     * This API tests the equality behaviour of Student object
     * Object Equality should work as per logic defined in equals method
     *
     * @throws Exception if any execution error during test
     */
    public void testEquality() throws Exception {

    /* Create some students */
        final Student firstStudent = new Student(1, "Adam", 'A');
        final Student secondStudent = new Student(2, "Donald", 'B');
        final Student secondSameStudent = new Student(2, "Donald", 'B');
        final Student firstSameStudent = firstStudent;

    /* Check equals functionality: should return 'true' */
        assertTrue(firstStudent.equals(firstSameStudent));

    /* Check equals functionality: should return 'false' */
        assertFalse(firstStudent.equals(secondStudent));

    /* Check equals functionality: should return 'true' */
        assertTrue(secondStudent.equals(secondSameStudent));
    }
}
