package fr.esiea.ex4A.hello;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Repository
class HelloRepository {
    final List<String> names = List.of(
            "Jaguabyss",
            "Coyolax",
            "Gazena",
            "Chickig",
            "Gladiabat",
            "Gladiafly",
            "Steeleen",
            "Marsharak",
            "Berriot",
            "Penguine"
    );
    private final Random random = new Random();
    final List<User> inscript = new ArrayList<User>();


    public HelloRepository()
    {
        User user = new User("toto@fr.fr","Nathalie","Nathalie","FR","F","M");
        inscript.add(user);
        User user2 = new User("toto2@fr.fr","Chalotte","Chalotte","FR","F","M");
        inscript.add(user2);
        User user3 = new User("toto3@fr.fr","Elise","Elise","FR","F","M");
        inscript.add(user3);
        User user4 = new User("toto4@fr.fr","Maria","Maria","FR","F","M");
        inscript.add(user4);
        User user5 = new User("toto5@fr.fr","Cindy","Cindy","FR","F","M");
        inscript.add(user5);
        User user6 = new User("toto6@fr.fr","Alexia","Alexia","FR","F","M");
        inscript.add(user6);
        User user7 = new User("toto7@fr.fr","Clemence","Clemence","FR","F","M");
        inscript.add(user7);

    }

    HelloData randomHello() {
        return new HelloData(names.get(random.nextInt(names.size())));
    }

    HelloData getHelloFor(String name) {
        int letterIndex = name.toLowerCase(Locale.ROOT).charAt(0) - 'a';
        return new HelloData((name + " ").repeat(1 + letterIndex).trim());
    }
    boolean addUser(User user)
    {
        if(inscript.contains(user))
        {
            return false;
        }
        else
        {
            inscript.add(user);
            return true;
        }

    }
}
