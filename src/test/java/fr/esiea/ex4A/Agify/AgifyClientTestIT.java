package fr.esiea.ex4A.Agify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Map;


class AgifyClientTestIT {

    @Test
    void verify_result_requests_Agify() throws Exception {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);
        Call<Map<String,String>> user = test.getAgeUser("guillaume","FR");
        Map<String, String> userMap= user.execute().body();
        AgifyUser userFinal =  new AgifyUser(userMap.get("name"), Integer.parseInt(userMap.get("age")),Integer.parseInt(userMap.get("count")),userMap.get("country_id"));

        Assertions.assertEquals(48,userFinal.getAge());
        Assertions.assertEquals("FR",userFinal.getCountryId());
        Assertions.assertEquals(36046,userFinal.getCount());
        Assertions.assertEquals("guillaume", userFinal.getName());
    }

}
