package com.example.mrpokerface.arithmetic;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Integer submittedAnswer;
    Button button_submit;
    EditText input_answer = (EditText)findViewById(R.id.input_answer);
    TextView output_score = (TextView)findViewById(R.id.variable_text_score);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ((TextView)findViewById(R.id.text_timer)).setText("60");
        input_answer.setTextColor(Color.GRAY);
        button_submit = findViewById(R.id.button_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submittedAnswer = Integer.parseInt(input_answer.getText().toString());
            }
        });
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
        int rightAnswers = 0;
        int wrongAnswers = 0;
        input_answer.setText("");
        input_answer.setTextColor(Color.BLACK);
        int i = 60;
        while(i > 0) {
            int answer = 0;
            String q = "";
            Integer a = RandomQuestion.getA();
            Integer b = RandomQuestion.getB();
            switch (RandomQuestion.getSign()) {
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
            i--;
        }
    }
}
