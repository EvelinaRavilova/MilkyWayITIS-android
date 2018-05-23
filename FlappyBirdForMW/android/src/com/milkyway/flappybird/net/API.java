package com.milkyway.flappybird.net;

import android.util.Log;

import com.milkyway.flappybird.net.models.Record;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
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

    public List<Record> getTopRecord() {
        final List<Record> records = new ArrayList<>();
        try {
            Response<List<Record>> response = service
                    .getTopRecords(1, 3)
                    .execute();
            records.addAll(response.body());
            Log.d("Response", records.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

}
