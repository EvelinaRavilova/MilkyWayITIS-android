package com.milkyway.flappybird.pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.GameType;
import com.milkyway.flappybird.R;
import com.milkyway.flappybird.games.GameActivity;
import com.milkyway.flappybird.games.MainActivity;

public class GameMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_menu);
        Button game = findViewById(R.id.game);
        Button score = findViewById(R.id.score);
        Button menu = findViewById(R.id.menu);


        final int gameType = getIntent().getExtras().getInt("gameType");
        // Определяем тип игры.
        Class gc = MainActivity.class;
        switch (gameType) {
            case GameType.FLAPPY:
                gc = MainActivity.class;
                break;
            case GameType.ARITHMETIC:
                gc = GameActivity.class;
                break;
            case GameType.PUZZLE:
                gc = GameActivity.class; // TODO: Заменить !!! Заглушка !!!
                break;
        }

        final Class gameClass = gc; // Требует объявить final
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameMenuActivity.this, gameClass);
                startActivity(i);
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameMenuActivity.this, GameScoreActivity.class);
                i.putExtra("gameType", gameType);
                startActivity(i);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameMenuActivity.this, MainMenu.class);
                startActivity(i);
            }
        });
    }
}
