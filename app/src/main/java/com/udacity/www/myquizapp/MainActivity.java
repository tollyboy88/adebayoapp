package com.udacity.www.myquizapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int totalScore = 0;
    TextView scoreTV;
    CheckBox checkBox1A, checkBox1B, checkBox1C, checkBox5A, checkBox5B, checkBox5C;
    RadioButton rbAnswerFor2, rbAnswerFor3, rbAnswerFor4, rbAnswerFor5, rbAnswerFor6, rbAnswerFor7;
    RadioGroup radioGroup2, radioGroup4;
    EditText answerFor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    private void viewAllComponents() {
        //RadioGroup views for available RadioButton options of Questions 2,4,6,7,9 and 10
        radioGroup2 = (RadioGroup) findViewById(R.id.option_group_2);
        radioGroup4 = (RadioGroup) findViewById(R.id.option_group_4);

        //CheckBox views for available options of Questions 1 and 5
        checkBox1A = (CheckBox) findViewById(R.id.option_1A);
        checkBox1B = (CheckBox) findViewById(R.id.option_1B);
        checkBox1C = (CheckBox) findViewById(R.id.option_1C);
        checkBox5A = (CheckBox) findViewById(R.id.option_5A);
        checkBox5B = (CheckBox) findViewById(R.id.option_5B);
        checkBox5C = (CheckBox) findViewById(R.id.option_5C);

        //RadioButton views for available options of Questions 2,4,6,7,9 and 10
        rbAnswerFor2 = (RadioButton) findViewById(R.id.option_2A);
        rbAnswerFor4 = (RadioButton) findViewById(R.id.option_2B);
        rbAnswerFor6 = (RadioButton) findViewById(R.id.option_2C);
        rbAnswerFor7 = (RadioButton) findViewById(R.id.option_4A);
        rbAnswerFor3 = (RadioButton) findViewById(R.id.option_4B);
        rbAnswerFor5 = (RadioButton) findViewById(R.id.option_4C);

        //EditText views for answer spaces of Questions 3 and 8
        answerFor3 = (EditText) findViewById(R.id.answer_Q3);
    }
// this method calculate the score for each user


    public void submitAnswers(View view) {
        /**
         * Function call to the viewAllComponents
         * this returns the different views used in the quiz using the "findViewById" method
         */
        viewAllComponents();

        // Are the correct options checked for Question 1?
        boolean checkedOption1A = checkBox1A.isChecked();
        boolean checkedOption1C = checkBox1C.isChecked();

        // Is the correct button checked for Question 2?
        boolean checkedOption2A = rbAnswerFor6.isChecked();


        // Get correct answer for Question 3
        Editable editableAnswer3 = answerFor3.getText();
        String correctAnswer3 = editableAnswer3.toString();


        // Is the correct button checked for Question 4?
        boolean checkedOption4A = rbAnswerFor3.isChecked();

        // Are the correct options checked for Question 5?
        boolean checkedOption5A = checkBox5C.isChecked();

// THE METHOD RESET ANSWER HELP TO RESET YOU YOU MAY AND RETURN ALL TO ZERO
    }

    public void resetAnswers(View view) {
        viewAllComponents();

        RadioGroup[] radioGroups = {radioGroup2, radioGroup4};
        for (RadioGroup radioGroup : radioGroups) {
            radioGroup.clearCheck();
            RadioButton[] radioButtons = {rbAnswerFor2, rbAnswerFor4, rbAnswerFor6, rbAnswerFor7};
            for (RadioButton radioButton : radioButtons) {
                radioButton.setTextColor(Color.BLACK);
            }
        }
        CheckBox[] checkBoxes = {checkBox1A, checkBox1B, checkBox1C, checkBox5A, checkBox5B, checkBox5C};
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setChecked(false);
            checkBox.setTextColor(Color.BLACK);
        }
        answerFor3.setText("");
        answerFor3.setTextColor(Color.BLACK);
        totalScore = 0;
        scoreTV.setText("Score: " + totalScore + "%");
    }

    private int calculateScore(boolean q1A, boolean q1C, boolean q2, boolean q4, boolean q5A, boolean q5B,
                               boolean q6, boolean q7, boolean q9, boolean q10, String q3, String q8) {
        int score = 0;
        if (q1A) {
            score += 5;

        }
        if (q1C) {
            score += 5;

        }
        if (q2) {
            score += 10;

        }
        if (q4) {
            score += 10;
        }
        if (q5A) {
            score += 5;

        }
        if (q5B) {
            score += 5;

        }
        if (q6) {
            score += 10;

        }
        if (q7) {
            score += 10;
        }

        return totalScore = score;
    }
}
