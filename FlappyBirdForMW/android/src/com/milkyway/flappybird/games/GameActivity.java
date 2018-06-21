package com.milkyway.flappybird.games;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.milkyway.flappybird.R;

public class GameActivity extends AppCompatActivity {

    Integer submittedAnswer;
    Button button_submit;
    EditText input_answer;
    TextView output_score;
    public int answer = 0;
    int rightAnswers = 0;
    int wrongAnswers = 0;
    TextView timer;
    int i = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        input_answer = (EditText)findViewById(R.id.input_answer);
        output_score = (TextView)findViewById(R.id.variable_text_score);
        timer = (TextView)findViewById(R.id.text_timer);
        timer.setText("60");
        input_answer.setTextColor(Color.GRAY);
        button_submit = findViewById(R.id.button_submit);
/*
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submittedAnswer = Integer.parseInt(input_answer.getText().toString());
            }
        });
*/
    }

    public void onGameMenuButtonClick(View view) {
        onStop(); //не уверен, что это работает так
        //хочу, чтобы в прошлое меню возвращалось
    }

    public void onGameStartButtonClick(View view) {
        findViewById(R.id.button_game_start).setEnabled(false);
        gameProcess();
    }

    private void gameProcess() {
        input_answer.setText("");
        input_answer.setTextColor(Color.BLACK);
        final RandomQuestion question = new RandomQuestion();
       // while(i > 0) {
            String q = "";
            question.generateQuestion();
            Integer a = question.getA();
            Integer b = question.getB();
            switch (question.getSign()) {
                case 0:
                    q = a.toString() + " + " + b.toString() + " = ";
                    answer = a + b;
                    break;

                case 1:
                    q = a.toString() + " - " + b.toString() + " = ";
                    answer = a - b;
                    break;

                case 2:
                    q = a.toString() + " * " + b.toString() + " = ";
                    answer = a * b;
                    break;

                case 3:
                    q = a.toString() + " / " + b.toString() + " = ";
                    answer = a / b;
                    break;
            }
            ((TextView) findViewById(R.id.text_question)).setText(q);
            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submittedAnswer = Integer.parseInt(input_answer.getText().toString());
                    if(answer == submittedAnswer) {
                        rightAnswers++;
                        String scores = rightAnswers + "/" + wrongAnswers;
                        output_score.setText(scores);
                    }
                    else {
                        wrongAnswers++;
                        String scores = rightAnswers + "/" + wrongAnswers;
                        output_score.setText(scores);
                    }

                }
            });
            input_answer.setText("");
            i--;
            timer.setText(i+"");
            gameProcess();

        /*((TextView) findViewById(R.id.text_question)).setText(q);
        if(button_submit.isPressed()) {
            if(answer == submittedAnswer) {
                rightAnswers++;
                String scores = rightAnswers + "/" + wrongAnswers;
                output_score.setText(scores);
            }
            else {
                wrongAnswers++;
                String scores = rightAnswers + "/" + wrongAnswers;
                output_score.setText(scores);
            }
        }
        input_answer.setText("");
        i--;*/
        //timer.setText(i+"");
        //gameProcess();
       // }
    }
}
