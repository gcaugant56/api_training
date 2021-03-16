package fr.esiea.ex4A.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import fr.esiea.ex4A.Match;
import fr.esiea.ex4A.Repository.UserRepository;
import fr.esiea.ex4A.Service.AgifyService;
import fr.esiea.ex4A.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
class UserController {

    private final UserRepository userRepository;

    private final AgifyClient client;

    private final AgifyService service;

    UserController(UserRepository userRepository, AgifyClient client, AgifyService service) {
        this.userRepository = userRepository;
        this.client = client;
        this.service = service;
    }

    @PostMapping(path = "/api/inscription",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    boolean subscribe(@RequestBody Map<String,String> requestBody)
    {

        User user = new User(requestBody.get("userEmail"),requestBody.get("userName"),requestBody.get("userTweeter"), requestBody.get("userCountry"),requestBody.get("userSex"), requestBody.get("userSexPref"));
        return userRepository.addUser(user);
    }

    @GetMapping(path = "/api/matches",produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    String match(@RequestParam(name = "userName" , required = true ) String userName,
                 @RequestParam(name = "userCountry", required = true) String userCountry) throws IOException {

        client.getAgeUser(userName, userCountry);
        AgifyUser principal = service.getAge(userName, userCountry);
        List<Match> matches = service.getMatches(principal.getAge());
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(matches);
        return result;
    }
}
