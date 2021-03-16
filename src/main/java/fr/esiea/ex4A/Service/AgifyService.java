package fr.esiea.ex4A.Service;

import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import fr.esiea.ex4A.Match;
import fr.esiea.ex4A.Repository.UserRepository;
import fr.esiea.ex4A.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {

    private final AgifyClient client;

    private final UserRepository userRepository;

    public AgifyService(AgifyClient client, UserRepository userRepository)
    {
        this.client = client;
        this.userRepository = userRepository;
    }

    public AgifyUser getAge(String name, String country) throws IOException {
        return (AgifyUser) client.getAgeUser(name,country).execute().body();
    }

    public ArrayList<Match> getMatches(int ageReference) throws IOException {
        ArrayList<Match> matches = new ArrayList<Match>();
        for(User match : userRepository.getInscript())
        {
            AgifyUser matchFind = getAge(match.getUserName(), match.getUserCountry());
            if(matchFind.getAge() - ageReference < 5 && matchFind.getAge() - ageReference > -5)
            {
                matches.add(new Match(match.getUserName(), match.getUserTweeter()));
            }
        }
        return matches;

    }

}
