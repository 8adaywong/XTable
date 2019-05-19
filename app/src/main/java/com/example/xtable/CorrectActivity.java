package com.example.xtable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CorrectActivity extends AppCompatActivity {

    Button next;

    MainGameActivity viewNew = new MainGameActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        next = (Button) findViewById(R.id.nextQuestion);
        next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                if(viewNew.getI() < (viewNew.getNumQ())) {

                startActivity(new Intent(CorrectActivity.this, MainGameActivity.class));
                 }
                else {
                    viewNew.setI(0);
                    startActivity(new Intent(CorrectActivity.this, ScoreActivity.class));
                }
             }
        });
    }
}
