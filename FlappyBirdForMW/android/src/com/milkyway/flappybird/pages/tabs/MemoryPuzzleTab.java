package com.milkyway.flappybird.pages.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.milkyway.flappybird.R;

public class MemoryPuzzleTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);

        TextView bestForToday = (TextView) rootView.findViewById(R.id.bestfortoday);
        TextView bestForMonth = (TextView) rootView.findViewById(R.id.bestformonth);
        TextView personalBest = (TextView) rootView.findViewById(R.id.personalbest);
        TextView worldRate = (TextView) rootView.findViewById(R.id.worldrate);

        //При установки очков подразумевается такая команда: bestForToday.setText("Best for month:  " + score);

        textView.setText("Memory puzzle");
        return rootView;
    }
}
