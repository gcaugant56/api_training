package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void Constructor()
    {
        User user = new User("caugant.guillaume@laposte.net","Panda", "PandaLeNarvalo","France","M","F");
        Assertions.assertNotNull(user);
    }
    @Test
    void getUserEmail()
    {
        User user = new User("caugant.guillaume@laposte.net","Panda", "PandaLeNarvalo","France","M","F");
        Assertions.assertEquals("caugant.guillaume@laposte.net",user.getUserEmail());
    }

    @Test
    void getUserName()
    {
        User user = new User("caugant.guillaume@laposte.net","Panda", "PandaLeNarvalo","France","M","F");
        Assertions.assertEquals("Panda",user.getUserName());
    }

    @Test
    void getUserTweeter()
    {
        User user = new User("caugant.guillaume@laposte.net","Panda", "PandaLeNarvalo","France","M","F");
        Assertions.assertEquals("PandaLeNarvalo",user.getUserTweeter());
    }

    @Test
    void getUserCountry()
    {
        User user = new User("caugant.guillaume@laposte.net","Panda", "PandaLeNarvalo","France","M","F");
        Assertions.assertEquals("France",user.getUserCountry());
    }

    @Test
    void getUserSex()
    {
        User user = new User("caugant.guillaume@laposte.net","Panda", "PandaLeNarvalo","France","M","F");
        Assertions.assertEquals("M",user.getUserSex());
    }

    @Test
    void getUserSexPref()
    {
        User user = new User("caugant.guillaume@laposte.net","Panda", "PandaLeNarvalo","France","M","F");
        Assertions.assertEquals("F",user.getUserSexPref());
    }
}
