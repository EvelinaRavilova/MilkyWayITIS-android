package com.milkyway.flappybird.pages.tabs;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.milkyway.flappybird.GameType;
import com.milkyway.flappybird.R;
import com.milkyway.flappybird.net.API;
import com.milkyway.flappybird.net.models.Record;

import java.util.HashMap;

public class ArithmeticTab extends Fragment {
    int game_type = GameType.ARITHMETIC;
    API api = new API();
    TextView bestForToday;
    TextView bestForMonth;
    TextView personalBest;
    TextView worldRate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        final int game_type = GameType.PUZZLE;
        bestForToday = rootView.findViewById(R.id.bestfortoday);
        bestForMonth = rootView.findViewById(R.id.bestformonth);
        personalBest = rootView.findViewById(R.id.personalbest);
        worldRate = rootView.findViewById(R.id.worldrate);

        personalBest.setText("Personal best: Loading...");
        bestForMonth.setText("Best for month: Loading...");
        bestForToday.setText("Best for today: Loading...");
        worldRate.setText("World rate: Loading...");

        new LoadRecords().execute();
        textView.setText("Arithmetic");
        return rootView;
    }

    class LoadRecords extends AsyncTask<Void, HashMap<String, Record>, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            HashMap<String, Record> records = new HashMap<>();
            records.put("none", api.getTop(game_type, "none"));
            //records.put("today", api.getTop(game_type, "day"));
            //records.put("month", api.getTop(game_type, "month"));
            records.put("world" , new Record(api.getTotalPosition(game_type)));
            publishProgress(records);
            return null;
        }

        @Override
        protected void onProgressUpdate(HashMap<String, Record>... values) {
            super.onProgressUpdate(values);
            HashMap<String, Record> records = values[0];
            bestForToday.setText("Best for today: None");
            bestForMonth.setText("Best for month: None");
            personalBest.setText("Personal best: " + records.get("none").score);
            worldRate.setText("World rate: " + records.get("world").score);
        }
    }
}