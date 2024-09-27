package com.example.petapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestLocalInterface {

    @GET("/name")
    Call<String> getName();
}
