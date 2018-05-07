package com.milkyway.flappybird;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class MainActivity extends AppCompatActivity  implements AndroidFragmentApplication.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupGameFragment();
    }

    private void setupGameFragment() {
        GameFragment fragment = new GameFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.game_fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public void exit() {

    }
}
