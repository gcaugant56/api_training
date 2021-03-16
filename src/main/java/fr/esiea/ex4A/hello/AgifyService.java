package fr.esiea.ex4A.hello;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {

    private final AgifyClient client;

    private final HelloRepository helloRepository;

    public AgifyService(AgifyClient client, HelloRepository helloRepository)
    {
        this.client = client;
        this.helloRepository = helloRepository;
    }

    public AgifyUser getAge(String name, String country) throws IOException {
        return (AgifyUser) client.getAgeUser(name,country).execute().body();
    }

    public ArrayList<Match> getMatches(int ageReference) throws IOException {
        ArrayList<Match> matches = new ArrayList<Match>();
        for(User match : helloRepository.inscript)
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
