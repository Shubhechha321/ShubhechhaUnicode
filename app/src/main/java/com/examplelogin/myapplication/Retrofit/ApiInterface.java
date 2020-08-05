package com.examplelogin.myapplication.Retrofit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather?appid=8f69ec8e2b3d2f8689e164ecb166382f&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);
}
