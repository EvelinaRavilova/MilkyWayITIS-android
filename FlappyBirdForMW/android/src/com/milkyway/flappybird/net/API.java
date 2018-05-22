package com.milkyway.flappybird.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    Retrofit retrofit;
    ServerApiInterface service;

    public API() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://milkywayitis.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ServerApiInterface.class);
    }
}
