package com.milkyway.flappybird.net;

import com.milkyway.flappybird.net.models.Position;
import com.milkyway.flappybird.net.models.Record;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServerApiInterface {


    // Лучшая игровая запись по указанной игре за указанный период
    @GET("top/")
    Call<Record> getTopRecord(
            @Query("game_type") Integer gameType,
            @Query("username") String username,
            @Query("filter_by") String filterBy
    );


    // Список личных игровых записей по определённой игре
    @GET("records/")
    Call<List<Record>> getRecords(
            @Query("game_type") Integer gameType,
            @Query("amount") Integer amount,
            @Query("username") String username
    );

    // Место в мировой статистике по указанной игре
    @GET("total_position/")
    Call<Position> getTotalPosition(
            @Query("username") String username,
            @Query("game_type") Integer gameType
    );

    // Новый рекорд
    @POST("new_record/")
    Call<Record> newRecord(
            @Header("Content-Type") String contentType,
            @Body Record record
    );

}
