package fr.esiea.ex4A.hello;

import org.springframework.stereotype.Service;

@Service
public class AgifyService {

    private final AgifyClient client;

    public AgifyService(AgifyClient client)
    {
        this.client = client;
    }

    public AgifyUser getAge(String name, String country)
    {
        return (AgifyUser) client.getAgeUser(name,country);
    }

}
