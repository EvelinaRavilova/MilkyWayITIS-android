package com.milkyway.flappybird.net;

import android.util.Log;

import com.milkyway.flappybird.net.models.Position;
import com.milkyway.flappybird.net.models.Record;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    /*
        Весь API работает только для username
        (hardcode)
     */

    Retrofit retrofit;
    ServerApiInterface service;

    public API() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://milkywayitis.pythonanywhere.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ServerApiInterface.class);
    }

    /*
        Список личных игровых записей по определённой игре
     */
    public List<Record> getRecords(int gameType, int amount) {
        final List<Record> records = new ArrayList<>();
        try {
            String username = "username";
            Response<List<Record>> response = service
                    .getRecords(gameType, amount, username)
                    .execute();
            records.addAll(response.body());
            Log.d("getRecords", records.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }


    public void newRecord(int gameType, int score) {
        final Record record = new Record("2018-05-26T21:21:00Z", gameType,
                score, "username");
        final String contentType = "application/json";
        service.newRecord(contentType, record).enqueue(new Callback<Record>() {
            @Override
            public void onResponse(Call<Record> call, Response<Record> response) {
                Log.d("newRecord", "Message sent");
            }

            @Override
            public void onFailure(Call<Record> call, Throwable t) {
                // ToDo: реализовать обработчик исключения
            }
        });
    }

    /**
     * Лучшая игровая запись по указанной игре за указанный период
     */
    public Record getTop(int gameType, String filterBy) {
        Record record = new Record();
        try {
            Response<Record> response = service
                    .getTopRecord(gameType, "username", filterBy)
                    .execute();
            //while (response.body() == null) {}
            record = new Record(response.body());
            Log.d("getTop", record.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return record;
    }

    /**
     * Место в мировой статистике по указанной игре
     *
     * @param gameType
     * @return Position
     */
    public Position getTotalPosition(int gameType) {
        Position position = new Position();
        try {
            Response<Position> response = service
                    .getTotalPosition("username", gameType)
                    .execute();
            //while (response.body() == null) {}
            position = response.body();
            Log.d("getTotalPosition", position.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return position;
    }

}
