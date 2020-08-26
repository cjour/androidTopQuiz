package com.example.topquiz.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topquiz.R;
import com.example.topquiz.model.Question;
import com.example.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestion;
    private Button mItem1;
    private Button mItem2;
    private Button mItem3;
    private Button mItem4;


    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();
        mScore = 0;
        mNumberOfQuestions = 4;
        mQuestion = findViewById(R.id.activity_game_question_text);
        mItem1 = findViewById(R.id.activity_game_answer1_btn);
        mItem2 = findViewById(R.id.activity_game_answer2_btn);
        mItem3 = findViewById(R.id.activity_game_answer3_btn);
        mItem4 = findViewById(R.id.activity_game_answer4_btn);

        mItem1.setTag(0);
        mItem2.setTag(1);
        mItem3.setTag(2);
        mItem4.setTag(3);

        mItem1.setOnClickListener(this);
        mItem2.setOnClickListener(this);
        mItem3.setOnClickListener(this);
        mItem4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    private void displayQuestion(final Question question){

        mQuestion.setText(question.getQuestion());
        mItem1.setText(question.getChoiceList().get(0));
        mItem2.setText(question.getChoiceList().get(1));
        mItem3.setText(question.getChoiceList().get(2));
        mItem4.setText(question.getChoiceList().get(3));

    }

    public QuestionBank generateQuestions() {

        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3));
    }

    @Override
    public void onClick(View view) {
        int responseIndex = (int) view.getTag();
        if(responseIndex == mCurrentQuestion.getAnswerIndex()){
            //good answer
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            //Wrong answer
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

        if(--mNumberOfQuestions == 0) {
            //End the game
            endGame();
        } else {
            mCurrentQuestion = mQuestionBank.getQuestion();
            displayQuestion(mCurrentQuestion);
        }

    }

    private void endGame(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .create()
                .show();
    }
}