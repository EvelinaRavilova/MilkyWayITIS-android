package com.milkyway.flappybird;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.games.MainActivity;
import com.milkyway.flappybird.net.API;
import com.milkyway.flappybird.net.models.Record;

import java.util.List;

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
            }
        });
    }
    class getTopRecord extends AsyncTask<Void, Void, List<Record>> {
        @Override
        protected List<Record> doInBackground(Void... voids) {
            Log.d("Deb", "HERE");
            List<Record> recordList = api.getRecords();
            Log.d("Deb", "HERE");
            publishProgress(voids);
            return recordList;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}


