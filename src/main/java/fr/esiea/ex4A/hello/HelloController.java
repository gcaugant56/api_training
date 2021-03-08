package fr.esiea.ex4A.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
class HelloController {

    private final HelloRepository helloRepository;

    HelloController(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    HelloData sayHello(@RequestParam(name = "name", required = false) String name) {
        final HelloData helloData;
        if (name == null || name.isBlank()) {
            helloData = helloRepository.randomHello();
        } else {
            helloData = helloRepository.getHelloFor(name);
        }
        return helloData;
    }

    @PostMapping(path = "/api/inscription",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    boolean subscribe(@RequestBody Map<String,String> requestBody)
    {

        User user = new User(requestBody.get("userEmail"),requestBody.get("userName"),requestBody.get("userTweeter"), requestBody.get("userCountry"),requestBody.get("userSex"), requestBody.get("userSexPref"));
        helloRepository.addUser(user);
        return true;
    }

    @GetMapping(path = "/api/matches",produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    String match(@RequestParam(name = "userName" , required = true ) String userName,
                 @RequestParam(name = "userCountry", required = true) String userCountry) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Match match = new Match("test1","test1");
        Match match2 = new Match("test2","test2");
        List<Match> matches = new ArrayList<>();
        matches.add(match);
        matches.add(match2);
        String result = mapper.writeValueAsString(matches);
        return result;
    }
}
