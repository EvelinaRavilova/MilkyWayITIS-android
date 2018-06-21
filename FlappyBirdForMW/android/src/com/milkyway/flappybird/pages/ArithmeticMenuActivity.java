package com.milkyway.flappybird.pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.R;

public class ArithmeticMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_menu);
        Button game = findViewById(R.id.game);
        Button score = findViewById(R.id.score);
        Button menu = findViewById(R.id.menu);

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ArithmeticMenuActivity.this, MainMenu.class);
                startActivity(i);
            }
        });
    }
}
