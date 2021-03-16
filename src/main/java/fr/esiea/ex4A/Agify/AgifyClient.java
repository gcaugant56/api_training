package fr.esiea.ex4A.Agify;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<AgifyUser> getAgeUser(@Query("name") String names, @Query("country_id") String country);
}
