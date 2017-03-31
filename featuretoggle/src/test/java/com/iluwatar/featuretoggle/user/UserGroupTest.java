package com.iluwatar.featuretoggle.user;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by starhq on 2017/3/31.
 */
public class UserGroupTest {

    @Test
    public void testAddUserToFreeGroup() throws Exception {
        User user = new User("Free User");
        UserGroup.addUserToFreeGroup(user);
        assertFalse(UserGroup.isPaid(user));
    }

    @Test
    public void testAddUserToPaidGroup() throws Exception {
        User user = new User("Paid User");
        UserGroup.addUserToPaidGroup(user);
        assertTrue(UserGroup.isPaid(user));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddUserToPaidWhenOnFree() throws Exception {
        User user = new User("Paid User");
        UserGroup.addUserToFreeGroup(user);
        UserGroup.addUserToPaidGroup(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddUserToFreeWhenOnPaid() throws Exception {
        User user = new User("Free User");
        UserGroup.addUserToPaidGroup(user);
        UserGroup.addUserToFreeGroup(user);
    }
}
