package com.milkyway.flappybird;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class GameFragment extends AndroidFragmentApplication {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        View view = initializeForView(new FBGame(), config);
        setupSurfaceView();
        return view;
    }

    private void setupSurfaceView() {
        if (graphics.getView() instanceof SurfaceView) {
            SurfaceView surfaceView = (SurfaceView) graphics.getView();
            surfaceView.setZOrderOnTop(false);
        }
    }
}