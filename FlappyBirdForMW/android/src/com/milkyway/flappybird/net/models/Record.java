package com.milkyway.flappybird.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {
    @SerializedName("date")
    @Expose
    public String date;

    @SerializedName("game_type")
    @Expose
    public Integer game_type;


    @SerializedName("score")
    @Expose
    public Integer score;

    @SerializedName("username")
    @Expose
    public String username;

    public Record(String date, Integer game_type, Integer score, String username) {
        this.date = date;
        this.game_type = game_type;
        this.score = score;
        this.username = username;
    }
    
    public Record(Record record) {
        this.date = record.date;
        this.game_type = record.game_type;
        this.score = record.score;
        this.username = record.username;
    }
    public Record(Position p) {
        date = "";
        username = "";
        score = p.position;
        game_type = 9;
    }

    public Record() {

    }

    @Override
    public String toString() {
        return "Record{" +
                "date='" + date + '\'' +
                ", game_type=" + game_type +
                ", score=" + score +
                ", username='" + username + '\'' +
                '}';
    }
    
}
