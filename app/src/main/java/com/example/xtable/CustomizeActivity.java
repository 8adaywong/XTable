package com.example.xtable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.xtable.R.id.questionNum;

public class CustomizeActivity extends AppCompatActivity {

    MainActivity newGame = new MainActivity();
    MainGameActivity gameNew = new MainGameActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);


        Button next;
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numQ = findViewById(questionNum);
                String s = numQ.getText().toString();
                int qNum = Integer.parseInt(s);
                if(qNum == 0) {
                    startActivity(new Intent(CustomizeActivity.this, MainActivity.class));

                } else {
                    newGame.setNumOfQuestions(qNum);
                    gameNew.setNumQ(qNum);
                    Log.d("XTable", Integer.toString(qNum));
                    startActivity(new Intent(CustomizeActivity.this, MainGameActivity.class));
                }
            }
        });

    }
}
