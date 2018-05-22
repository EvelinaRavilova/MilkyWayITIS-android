package com.milkyway.flappybird.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {
    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("game_chat")
    @Expose
    private Integer game_chat;


    @SerializedName("score")
    @Expose
    private Integer score;

    @SerializedName("username")
    @Expose
    private String username;
}
