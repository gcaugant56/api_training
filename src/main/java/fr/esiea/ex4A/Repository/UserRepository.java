package fr.esiea.ex4A.Repository;

import fr.esiea.ex4A.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserRepository {

    private List<User> inscript = new ArrayList<User>();


    public UserRepository()
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

    public List<User> getInscript()
    {
        return this.inscript;
    }

    public boolean addUser(User user)
    {
        for(User userlist : inscript)
        {
            if (userlist.getUserEmail().equals(user.getUserEmail()))
            {
                return false;
            }
        }
        inscript.add(user);
        return true;

    }
}
