package fr.esiea.ex4A.Service;

import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import fr.esiea.ex4A.Match;
import fr.esiea.ex4A.Repository.UserRepository;
import fr.esiea.ex4A.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AgifyService {

    private final AgifyClient client;

    private final UserRepository userRepository;

    private final Map<String,Integer> cache = new HashMap<>();

    public AgifyService(AgifyClient client, UserRepository userRepository)
    {
        this.client = client;
        this.userRepository = userRepository;
    }

    public AgifyUser getAge(String name, String country) throws IOException {
        Map<String, String> userMap = client.getAgeUser(name,country).execute().body();
        AgifyUser userFinal =  new AgifyUser(userMap.get("name"), Integer.parseInt(userMap.get("age")),Integer.parseInt(userMap.get("count")),userMap.get("country_id"));
        return userFinal;
    }

    public ArrayList<Match> getMatches(int ageReference) throws IOException {
        ArrayList<Match> matches = new ArrayList<Match>();
        for(User match : userRepository.getInscript()) {
            int ageMatch = getFromCache(match);
            if(ageMatch - ageReference < 5 && ageMatch - ageReference > -5) {
                matches.add(new Match(match.getUserName(), match.getUserTweeter()));
            }
        }
        return matches;
    }

    public int getFromCache(User user) throws IOException {
        int value = 0;
        if(!cache.containsKey(user.getUserName()+"-"+user.getUserCountry())) {
            AgifyUser matchFind = getAge(user.getUserName(), user.getUserCountry());
            cache.put(user.getUserName()+"-"+user.getUserCountry(),matchFind.getAge());
            value = matchFind.getAge();
        }
        else {
            value = cache.get(user.getUserName()+"-"+user.getUserCountry());
        }
        return value;
    }

}
