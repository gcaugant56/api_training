package fr.esiea.ex4A.Repository;

import fr.esiea.ex4A.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserRepository {

    private final List<User> inscript = new ArrayList<User>();


    public UserRepository()
    {
        inscript.add( new User("toto@fr.fr","Nathalie","Nathalie","FR","F","M"));
        inscript.add(new User("toto2@fr.fr","Chalotte","Chalotte","FR","F","M"));
        inscript.add(new User("toto3@fr.fr","Elise","Elise","FR","F","M"));
        inscript.add(new User("toto4@fr.fr","Maria","Maria","FR","F","M"));
        inscript.add(new User("toto5@fr.fr","Cindy","Cindy","FR","F","M"));
        inscript.add(new User("toto6@fr.fr","Alexia","Alexia","FR","F","M"));
        inscript.add(new User("toto7@fr.fr","Clemence","Clemence","FR","F","M"));

    }

    public List<User> getInscript()
    {
        return this.inscript;
    }

    public boolean addUser(User user) {
        for(User userlist : inscript) {
            if (userlist.getUserEmail().equals(user.getUserEmail())) {
                return false;
            }
        }
        inscript.add(user);
        return true;
    }
}
