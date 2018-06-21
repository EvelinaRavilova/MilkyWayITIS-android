package com.milkyway.flappybird.pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.R;
import com.milkyway.flappybird.games.MainActivity;

public class FlappyBirdMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flappy_bird_menu);
        Button game = (Button)findViewById(R.id.game);
        Button score = (Button)findViewById(R.id.score);
        Button menu = (Button)findViewById(R.id.menu);

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FlappyBirdMenuActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FlappyBirdMenuActivity.this, MainMenu.class);
                startActivity(i);
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FlappyBirdMenuActivity.this, FlappyBirdScoreActivity.class);
                startActivity(i);
            }
        });

    }
}
