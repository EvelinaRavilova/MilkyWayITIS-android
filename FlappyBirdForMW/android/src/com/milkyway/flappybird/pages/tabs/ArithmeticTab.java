package com.milkyway.flappybird.pages.tabs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.milkyway.flappybird.R;

public class ArithmeticTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_flappy, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        textView.setText("I'm Arithmetic");
        return rootView;
    }
}
