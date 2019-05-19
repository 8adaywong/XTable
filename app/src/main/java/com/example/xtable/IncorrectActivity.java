package com.example.xtable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IncorrectActivity extends AppCompatActivity {

    Button next;
    MainGameActivity viewGame = new MainGameActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrect);




        next = (Button) findViewById(R.id.nextQuestion2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewGame.getI() < (viewGame.getNumQ())) {

                    startActivity(new Intent(IncorrectActivity.this, MainGameActivity.class));
                }
                else {
                    viewGame.setI(0);
                    startActivity(new Intent(IncorrectActivity.this, ScoreActivity.class));
                }
            }
        });

    }
}
