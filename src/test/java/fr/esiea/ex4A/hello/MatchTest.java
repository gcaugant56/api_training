package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {


    @Test
    void getName() {
        Match match = new Match("Guillaume","twitter");
        Assertions.assertEquals("Guillaume",match.getName());
    }

    @Test
    void getTwitter() {
        Match match = new Match("Guillaume","twitter");
        Assertions.assertEquals("twitter",match.getTwitter());
    }
}
