package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AgifyClientTestIT {

    @Test
    void verify_result_requests_Agify() throws Exception {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<AgifyUser> user = test.getAgeUser("guillaume","FR");
        AgifyUser userFinal = user.execute().body();
        Assertions.assertEquals(48,userFinal.getAge());
        Assertions.assertEquals("FR",userFinal.getCountryId());
        Assertions.assertEquals(36046,userFinal.getCount());
        Assertions.assertEquals("guillaume", userFinal.getName());
    }

}
