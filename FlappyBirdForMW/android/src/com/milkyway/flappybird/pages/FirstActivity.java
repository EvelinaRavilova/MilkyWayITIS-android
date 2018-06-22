package com.milkyway.flappybird.pages;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.milkyway.flappybird.R;
import com.milkyway.flappybird.net.API;

public class FirstActivity extends AppCompatActivity {
    Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        signIn = findViewById(R.id.sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirstActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        new ApiUp().execute();

    }

    class ApiUp extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            API api = new API();
            api.getRecords(1, 4);
            api.getTop(1, "none");
            api.getTotalPosition(1);
            api.newRecord(1, 69);
            return null;
        }
    }
}
