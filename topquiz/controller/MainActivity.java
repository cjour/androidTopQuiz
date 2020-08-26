package com.example.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.topquiz.R;
import com.example.topquiz.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView myGreetingText;
    private EditText myNameInput;
    private Button myPlayButton;
    private User mUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGreetingText = findViewById(R.id.activity_main_greeting_text);
        myNameInput = findViewById(R.id.activity_main_name_input);
        myPlayButton = findViewById(R.id.activity_main_play_btn);

        myPlayButton.setEnabled(false);
        myNameInput.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               myPlayButton.setEnabled(charSequence.toString().length() !=0);
           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });

        myPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = myNameInput.getText().toString();
                mUser.setFirstname(user);
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivity);
            }
        });
    }
}