package com.milkyway.flappybird.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {
    @SerializedName("position")
    @Expose
    public Integer position;

    public Position(Integer position) {
        this.position = position;
    }

    public Position() {
        // empty constructor for empty reference
    }
    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
