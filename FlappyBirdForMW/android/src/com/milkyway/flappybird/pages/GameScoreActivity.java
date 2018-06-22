package com.milkyway.flappybird.pages;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.milkyway.flappybird.Main2Activity;
import com.milkyway.flappybird.R;
import com.milkyway.flappybird.net.API;
import com.milkyway.flappybird.net.models.Record;

import java.util.List;

public class GameScoreActivity extends AppCompatActivity {

    API api = new API();
    int gameType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic_score);
        gameType = getIntent().getExtras().getInt("gameType");
        new getRecords().execute();

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
            DataPoint[] data = new DataPoint[records.length];
            for (int i = 0; i < records.length; i++) {
                data[i] = new DataPoint(i, records[i].score);
            }
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(data);
            graph.addSeries(series);
        }
    }

}
