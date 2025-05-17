package com.example.proyecto120325;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactService {

        @GET("fca")
        Call<List<Contact>> listContacts();

}
