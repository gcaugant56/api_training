package fr.esiea.ex4A.Agify;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface AgifyClient {
    @GET("/")
    Call<Map<String,String>> getAgeUser(@Query("name") String names, @Query("country_id") String country);
}
