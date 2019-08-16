package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setup(){

        user = new User("123-4567", "plum");

    }

    @Test
    public void testLoginWithCorrectCredentials(){

        assertTrue(user.attemptLogin("123-4567", "plum"));

    }

    @Test
    public void testLoginWithIncorrectPassword(){

        assertFalse(user.attemptLogin("123-4567", "peach"));

    }

    @Test
    public void testLoginWithIncorrectUsername(){

        assertFalse(user.attemptLogin("124-1234", "plum"));

    }

}
