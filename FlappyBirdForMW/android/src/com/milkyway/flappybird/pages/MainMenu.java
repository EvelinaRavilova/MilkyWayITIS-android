package com.milkyway.flappybird.pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.milkyway.flappybird.R;

public class MainMenu extends AppCompatActivity {
    Button flappyBird, arithmetic, puzzle, exit, statistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        String username = getIntent().getExtras().getString("username");
        Log.d("extra", username);
        flappyBird = findViewById(R.id.flappy_bird);
        arithmetic = findViewById(R.id.arithmetic);
        puzzle = findViewById(R.id.puzzle);
        exit = findViewById(R.id.exit);
        statistics = findViewById(R.id.statistics);
        TextView textView = findViewById(R.id.username_main_screen);
        textView.setText(username);
        flappyBird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenu.this, FlappyBirdMenuActivity.class);
                startActivity(i);
            }
        });
        arithmetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenu.this, ArithmeticMenuActivity.class);
                startActivity(i);
            }
        });
        puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenu.this, MemoryPuzzleMenuActivity.class);
                startActivity(i);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenu.this, FirstActivity.class);
                startActivity(i);
            }
        });
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenu.this, PersonalStatisticsActivity.class);
                startActivity(i);
            }
        });
    }
}
