package com.example.optativa_02;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatFactService {
    @GET("fact")
    Call<CatFact> getCatFact();
}