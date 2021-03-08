package fr.esiea.ex4A.hello;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface AgifyClient {
    @GET("/")
    Call<AgifyUser> getAgeUser(@Query("name") String names, @Query("country_id") String country);
}
