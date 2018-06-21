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
        View rootView = inflater.inflate(R.layout.fragment_flappy, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText("I'm Puzzle");
        return rootView;
    }
}
