package com.milkyway.flappybird.games;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.milkyway.flappybird.R;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {


    Button button_start;
    Button button_submit;
    TextView timer;
    TextView scores;
    TextView question;
    TextView input_answer;
    Integer submittedAnswer;
    Integer rightAnswers;
    Integer wrongAnswers;
    Integer scoresGeneral = 0;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        button_submit = findViewById(R.id.button_submit);
        button_submit.setEnabled(false);
        button_start = findViewById(R.id.button_game_start);
        timer = findViewById(R.id.text_timer);
        scores = findViewById(R.id.variable_text_score);
        question = findViewById(R.id.text_question);
        input_answer = findViewById(R.id.input_answer);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input_answer.getText().toString().equals("")) {
                    submittedAnswer = Integer.parseInt(input_answer.getText().toString());
                    if (submittedAnswer == RandomQuestion.getAnswer()) {
                        updateScore(true);
                    } else {
                        updateScore(false);
                    }
                    input_answer.setText("");
                    if (!timer.getText().equals("0")) {
                        askQuestion();
                    }
                }
            }
        });
    }

    public void onGameMenuButtonClick(View view) {
        finish();
    }

    public void onGameStartButtonClick(View view) {
        button_start.setEnabled(false);
        button_submit.setEnabled(true);
        String s = "0/0";
        scores.setText(s);
        gameProcess();

    }

    public void gameProcess() {
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                Long l = millisUntilFinished / 1000;
                timer.setText(l.toString());
            }

            public void onFinish() {
                timer.setText("0");
                button_submit.setEnabled(false);
                button_start.setEnabled(true);
                if (scoresGeneral < 0) scoresGeneral = 0;
                setScore();
            }
        }
                .start();
        rightAnswers = 0;
        wrongAnswers = 0;
        askQuestion();
    }
    public void setScore(){
        sPref = getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        for (int i = 1; i < 9; i++) {
            ed.putInt(i + "Score", sPref.getInt((i + 1) + "Score",0));
        }
        ed.putInt("9Score", scoresGeneral);
        ed.commit();
        Toast.makeText(this, "Text saved " +  sPref.getInt(  "Score", 0), Toast.LENGTH_SHORT).show();
    }

    public void askQuestion() {
        RandomQuestion.generateQuestion();
        Integer a = RandomQuestion.getA();
        Integer b = RandomQuestion.getB();
        String q = "";
        switch (RandomQuestion.getSign()) {
            case 0:
                q = a.toString() + " + " + b.toString() + " = ";
                break;

            case 1:
                q = a.toString() + " - " + b.toString() + " = ";
                break;

            case 2:
                q = a.toString() + " * " + b.toString() + " = ";
                break;

            case 3:
                q = a.toString() + " / " + b.toString() + " = ";
                break;
        }
        question.setText(q);
    }

    public void updateScore(boolean correct) {
        if (correct) {
            rightAnswers++;
            String s = "" + rightAnswers + "/" + wrongAnswers;
            scores.setText(s);
            scoresGeneral += 100;
        } else {
            wrongAnswers++;
            String s = "" + rightAnswers + "/" + wrongAnswers;
            scores.setText(s);
            scoresGeneral -= 50;
        }

    }

}
