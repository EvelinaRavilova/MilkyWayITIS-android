package com.milkyway.flappybird.pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.R;

public class MainMenu extends AppCompatActivity {
    Button flappyBird, arithmetic, puzzle, exit, statistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        flappyBird = (Button)findViewById(R.id.flappy_bird);
        arithmetic = (Button)findViewById(R.id.arithmetic);
        puzzle = (Button)findViewById(R.id.puzzle);
        exit = (Button)findViewById(R.id.exit);
        statistics = (Button)findViewById(R.id.statistics);
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
