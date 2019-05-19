package com.example.xtable;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare variables
    Button firstButton, secondButton, thirdButton, fourthButton;
    private static int numOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //click button to change activity screen
        firstButton = (Button) findViewById(R.id.firstButton);
        secondButton = (Button) findViewById(R.id.secondButton);
        thirdButton = (Button) findViewById(R.id.thirdButton);

        firstButton = (Button) findViewById(R.id.firstButton);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfQuestions = 10;
                startActivity(new Intent(MainActivity.this, MainGameActivity.class));
            }
        });

        secondButton = (Button) findViewById(R.id.secondButton);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfQuestions = 20;
                startActivity(new Intent(MainActivity.this, MainGameActivity.class));
            }
        });

        thirdButton = (Button) findViewById(R.id.thirdButton);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfQuestions = 30;
                startActivity(new Intent(MainActivity.this, MainGameActivity.class));
            }
        });

        fourthButton = (Button) findViewById(R.id.fourthButton);
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomizeActivity.class));
            }
        });




    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

}
