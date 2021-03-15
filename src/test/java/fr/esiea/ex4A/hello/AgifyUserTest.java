package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AgifyUserTest {



    AgifyUser AgifyUserTest() throws IOException {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<AgifyUser> user = test.getAgeUser("guillaume","FR");

        AgifyUser userFinal = user.execute().body();
        return userFinal;
    }

    @Test
    void getName() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals("guillaume",testUser.getName());

    }

    @Test
    void setName() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setName("toto");
        Assertions.assertEquals("toto",testUser.getName());
    }

    @Test
    void getAge() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals(48,testUser.getAge());
    }

    @Test
    void setAge() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setAge(24);
        Assertions.assertEquals(24,testUser.getAge());
    }

    @Test
    void getCount() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals(36046,testUser.getCount());
    }

    @Test
    void setCount() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setCount(10000);
        Assertions.assertEquals(10000,testUser.getCount());
    }

    @Test
    void getCountryId() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals("FR",testUser.getCountryId());
    }

    @Test
    void setCountryId() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setCountryId("EN");
        Assertions.assertEquals("EN",testUser.getCountryId());
    }
}
