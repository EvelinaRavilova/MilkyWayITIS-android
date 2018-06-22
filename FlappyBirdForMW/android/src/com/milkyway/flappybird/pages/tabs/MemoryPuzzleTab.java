package com.milkyway.flappybird.pages.tabs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.milkyway.flappybird.GameType;
import com.milkyway.flappybird.R;
import com.milkyway.flappybird.net.API;
import com.milkyway.flappybird.net.models.Position;
import com.milkyway.flappybird.net.models.Record;

import java.util.HashMap;

public class MemoryPuzzleTab extends Fragment {
    int game_type = GameType.PUZZLE;
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

        personalBest.setText("Лучший результат за все время: Loading...");
        bestForMonth.setText("Лучший результат за месяц: Loading...");
        bestForToday.setText("Лучший результат за сегодня: Loading...");
        worldRate.setText("Место в мире: Loading...");

        new LoadRecords().execute();
        textView.setText("Memory puzzle");
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
            bestForToday.setText("Лучший результат за день: None");
            bestForMonth.setText("Лучший результат за месяц: None");
            personalBest.setText("Лучший результат за все время: " + records.get("none").score);
            worldRate.setText("Место в мире: " + records.get("world").score);
        }
    }
}
