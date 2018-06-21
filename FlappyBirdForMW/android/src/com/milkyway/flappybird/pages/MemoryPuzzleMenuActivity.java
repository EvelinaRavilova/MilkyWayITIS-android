package com.milkyway.flappybird.pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.R;

public class MemoryPuzzleMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_puzzle_menu);
        Button game = (Button)findViewById(R.id.game);
        Button score = (Button)findViewById(R.id.score);
        Button menu = (Button)findViewById(R.id.menu);

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MemoryPuzzleMenuActivity.this, PuzzleScoreActivity.class);
                startActivity(i);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MemoryPuzzleMenuActivity.this, MainMenu.class);
                startActivity(i);
            }
        });
    }
}
