package com.example.xtable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView score, quote;
    Button playAgain, exit;
    MainGameActivity finalGame = new MainGameActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = (TextView) findViewById(R.id.score);
        String finalScore = Integer.toString(finalGame.getCorrect()) + "/" + finalGame.getNumQ();
        score.setText(finalScore);

        double scoreTotal = (double) (finalGame.getCorrect())/(finalGame.getNumQ());
        Log.d("XTable", Double.toString(scoreTotal));
        quote = (TextView) findViewById(R.id.Quote);
        if(scoreTotal == 1) {
            quote.setText("Perfect!");
        }
        else if(scoreTotal >= 0.8) {
            quote.setText("Amazing!");
        }
        else if(scoreTotal >= 0.5) {
            quote.setText("Good Job!");
        }
        else {
            quote.setText("Better Luck Next Time!");
        }
        finalGame.setCorrect(0);

        playAgain = (Button) findViewById(R.id.PlayAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScoreActivity.this, MainGameActivity.class));
            }
        });

        exit = (Button) findViewById(R.id.Exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScoreActivity.this, MainActivity.class));
            }
        });

    }
}
