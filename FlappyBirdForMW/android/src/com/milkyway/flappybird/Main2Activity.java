package com.milkyway.flappybird;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.net.API;

public class Main2Activity extends AppCompatActivity {

    API api = new API();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this,
                        MainActivity.class);
                startActivity(i);

            }
        });
        new getTopRecord().execute();
        Button playground = findViewById(R.id.playground);
        playground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, PlayGround.class);
                startActivity(i);
            }
        });
    }
    class getTopRecord extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            api.getTopRecord();
            publishProgress(voids);
            return voids[0];
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}


