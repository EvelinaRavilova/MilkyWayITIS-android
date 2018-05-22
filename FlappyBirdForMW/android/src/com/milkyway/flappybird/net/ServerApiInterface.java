package com.milkyway.flappybird.net;

import com.milkyway.flappybird.net.models.Record;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServerApiInterface {

    @GET("top/")
    Call<List<Record>> getTopRecords(
            @Query("game_type") Integer gameType,
            @Query("amount") Integer amount
    );

    @POST("new_record/")
    Call<Record> newRecord(
            @Header("Content-Type") String contentType,
            @Body Record record
    );

}
