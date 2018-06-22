package com.milkyway.flappybird.pages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.milkyway.flappybird.R;

public class GameScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_score);
        final int gameType = getIntent().getExtras().getInt("gameType");
        
    }
}
