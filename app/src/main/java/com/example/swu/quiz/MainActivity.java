package com.example.swu.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button trueButton, falseButton, nextButton;
    private TextView questionText, scoreText;
    private List<Question> questionBank;
    private int number =0;
    private int score =0;
    private static final String TAG = "Main Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        initQuestionBank();
        questionText.setText(questionBank.get(0).getQuestionText());
        scoreText.setText("Score: "+ score);





    }

    private void submitAnswer(boolean b) {
        if(questionBank.get(number).checkAnswer(b))
        {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            score++;
            scoreText.setText("Score: "+ score);
        }
        else
        {
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();

        }
    }


    private void next() {
        number++;

        if(number<questionBank.size()) {

            questionText.setText(questionBank.get(number).getQuestionText());
            trueButton.setEnabled(true);
            falseButton.setEnabled(true);


        }
        else {
            trueButton.setEnabled(false);
            falseButton.setEnabled(false);

            Intent i = new Intent(MainActivity.this, endingActivity.class);
            i.putExtra("message1", "THE END");
            i.putExtra("m2", ("Your Score: "+ score +"/"+questionBank.size()));
            startActivity(i);


        }

    }



    private void initQuestionBank() {
        questionBank = new ArrayList<>();
        questionBank.add(new Question(getString(R.string.caca_question), true));
        questionBank.add(new Question(getString(R.string.bird_question), true));
        questionBank.add(new Question(getString(R.string.satellite), false));
        questionBank.add(new Question(getString(R.string.school), true));
        questionBank.add(new Question(getString(R.string.insects), false));
        questionBank.add(new Question(getString(R.string.sun), true));
        questionBank.add(new Question(getString(R.string.tattoo), false));
        questionBank.add(new Question(getString(R.string.worm), false));
        questionBank.add(new Question(getString(R.string.Oxford), true));
        questionBank.add(new Question(getString(R.string.nose), true));




    }

    private void setListeners() {
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    private void wireWidgets() {
        trueButton= (Button) findViewById(R.id.button_true);
        falseButton= (Button) findViewById(R.id.button_false);
        nextButton= (Button) findViewById(R.id.button_next);
        questionText = (TextView) findViewById(R.id.text_question);
        scoreText = (TextView) findViewById(R.id.text_score);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_next:
                next();
                break;
            case R.id.button_true:
                submitAnswer(true);
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                break;
            case R.id.button_false:
                submitAnswer(false);
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                break;


        }



    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: method fired");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: method fired");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: method fired");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: method fired");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: method fired");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "OnSaveInstanceState: method fired");
    }
}
