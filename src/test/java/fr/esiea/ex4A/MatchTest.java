package fr.esiea.ex4A;

import fr.esiea.ex4A.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
