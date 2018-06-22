package com.milkyway.flappybird.pages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.milkyway.flappybird.Main2Activity;
import com.milkyway.flappybird.R;
import com.milkyway.flappybird.ZBHelpers.AssetLoader;
import com.milkyway.flappybird.games.GameActivity;
import com.milkyway.flappybird.games.GameFragment;
import com.milkyway.flappybird.games.MainActivity;
import com.milkyway.flappybird.net.API;
import com.milkyway.flappybird.net.models.Record;

import java.util.ArrayList;
import java.util.List;

public class GameScoreActivity extends AppCompatActivity {

    API api = new API();
    int gameType;
    SharedPreferences sPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_score);
        gameType = getIntent().getExtras().getInt("gameType");
        new getRecords().execute();
        switch (gameType){
            case 0:
                getWindow().setBackgroundDrawableResource(R.drawable.fb_back);
                break;
            case 1:
                getWindow().setBackgroundDrawableResource(R.drawable.arith_back);
                break;
            case 2:
                getWindow().setBackgroundDrawableResource(R.drawable.puzzle_back);
                break;
        }
        /*ConstraintLayout constraintLayout = new ConstraintLayout(this);
        constraintLayout.setBackgroundResource(R.drawable.arith_back);*/
        Button menu = findViewById(R.id.menu);
                menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(GameScoreActivity.this, MainMenu.class);
                        startActivity(i);
                    }
                });

    }
    class getRecords extends AsyncTask<Void, Record, List<Record>> {
        @Override
        protected List<Record> doInBackground(Void... voids) {
            List<Record> recordList = api.getRecords(gameType, 9);
            Record [] records = new Record[recordList.size()];
            for (int i = 0; i < recordList.size(); i++) {
                records[i] = recordList.get(i);
            }
            publishProgress(records);
            return recordList;
        }

        @Override
        protected void onProgressUpdate(Record... records) {
            super.onProgressUpdate();

            // массивом records, сделать графики

            // Линейный график
            GraphView graph = findViewById(R.id.graph);
            DataPoint[] data = new DataPoint[9];
           /* for (int i = 0; i < records.length; i++) {
                data[i] = new DataPoint(i, records[i].score);
            }*/
            ArrayList<Integer> scores;
            if (gameType == 0) {
                scores = AssetLoader.getScores();
                for (int i = 0; i < 9; i++) {
                    if (scores.size() == 0) {
                        data[i] = new DataPoint(i, 0);
                    } else {
                        data[i] = new DataPoint(i, scores.get(i));
                    }
                }
            } else {
                TextView textView = (TextView) findViewById(R.id.textView4);
                String s = "";
                sPref =  getSharedPreferences("myPref",MODE_PRIVATE);
                Toast.makeText(GameScoreActivity.this, "Text saved " +  sPref.getInt(  "9Score", 0), Toast.LENGTH_SHORT).show();
                for (int i = 0; i < 9; i++) {
                    data[i] = new DataPoint(i, sPref.getInt((i + 1) + "Score", 0));
                    s = s + " " + data[i];
                }
                textView.setText(s);
            }

            BarGraphSeries<DataPoint> series = new BarGraphSeries<>(data);
            graph.addSeries(series);
            series.setColor(Color.argb(255, 255, 255, 255));

            graph.getGridLabelRenderer().setGridColor(Color.argb(255, 255, 255, 255));
            graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.argb(255, 255, 255, 255));
            graph.getGridLabelRenderer().setVerticalLabelsColor(Color.argb(255, 255, 255, 255));

            series.setSpacing(30);
        }
    }

}
