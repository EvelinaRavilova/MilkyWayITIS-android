package com.milkyway.flappybird.games;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.R;

public class MainActivityArithm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartButtonClick(View view) {
        Intent intent = new Intent(MainActivityArithm.this, GameActivity.class);
        startActivity(intent);
    }

    public void onScoresButtonClick(View view) {
        Intent intent = new Intent(MainActivityArithm.this, ScoresActivity.class);
        startActivity(intent);
    }

    public void onMenuButtonClick(View view) {

    }
}
