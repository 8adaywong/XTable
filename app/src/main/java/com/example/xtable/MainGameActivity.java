package com.example.xtable;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.util.Random;

public class MainGameActivity extends AppCompatActivity {

    Button submit;
    TextView myQuestionTextView;
    int question;
    Random rand = new Random();
    int r = rand.nextInt(92-1) + 1;;
    int index = r;
    private static int correct;
    TextView scoreTextView;
    MainActivity newView = new MainActivity();
    private static int i;
    int NumQ= newView.getNumOfQuestions();
    String scoreTotal;

    private Question[] myQuestionList = new Question[]{
            new Question(R.string.question_1, 0),
            new Question(R.string.question_2, 0),
            new Question(R.string.question_3, 0),
            new Question(R.string.question_4, 0),
            new Question(R.string.question_5, 0),
            new Question(R.string.question_6, 0),
            new Question(R.string.question_7, 0),
            new Question(R.string.question_8, 0),
            new Question(R.string.question_9, 0),
            new Question(R.string.question_10, 0),
            new Question(R.string.question_11, 0),
            new Question(R.string.question_12, 0),
            new Question(R.string.question_13, 0),
            new Question(R.string.question_14, 1),
            new Question(R.string.question_15, 2),
            new Question(R.string.question_16, 3),
            new Question(R.string.question_17, 4),
            new Question(R.string.question_18, 5),
            new Question(R.string.question_19, 6),
            new Question(R.string.question_20, 7),
            new Question(R.string.question_21, 8),
            new Question(R.string.question_22, 9),
            new Question(R.string.question_23, 10),
            new Question(R.string.question_24, 11),
            new Question(R.string.question_25, 12),
            new Question(R.string.question_26, 4),
            new Question(R.string.question_27, 6),
            new Question(R.string.question_28, 8),
            new Question(R.string.question_29, 10),
            new Question(R.string.question_30, 12),
            new Question(R.string.question_31, 14),
            new Question(R.string.question_32, 16),
            new Question(R.string.question_33, 18),
            new Question(R.string.question_34, 20),
            new Question(R.string.question_35, 22),
            new Question(R.string.question_36, 24),
            new Question(R.string.question_37, 9),
            new Question(R.string.question_38, 12),
            new Question(R.string.question_39, 15),
            new Question(R.string.question_40, 18),
            new Question(R.string.question_41, 21),
            new Question(R.string.question_42, 24),
            new Question(R.string.question_43, 27),
            new Question(R.string.question_44, 30),
            new Question(R.string.question_45, 33),
            new Question(R.string.question_46, 36),
            new Question(R.string.question_47, 16),
            new Question(R.string.question_48, 20),
            new Question(R.string.question_49, 24),
            new Question(R.string.question_50, 28),
            new Question(R.string.question_51, 32),
            new Question(R.string.question_52, 36),
            new Question(R.string.question_53, 40),
            new Question(R.string.question_54, 44),
            new Question(R.string.question_55, 48),
            new Question(R.string.question_56, 25),
            new Question(R.string.question_57, 30),
            new Question(R.string.question_58, 35),
            new Question(R.string.question_59, 40),
            new Question(R.string.question_60, 45),
            new Question(R.string.question_61, 50),
            new Question(R.string.question_62, 55),
            new Question(R.string.question_63, 60),
            new Question(R.string.question_64, 36),
            new Question(R.string.question_65, 42),
            new Question(R.string.question_66, 48),
            new Question(R.string.question_67, 54),
            new Question(R.string.question_68, 60),
            new Question(R.string.question_69, 66),
            new Question(R.string.question_70, 72),
            new Question(R.string.question_71, 49),
            new Question(R.string.question_72, 56),
            new Question(R.string.question_73, 63),
            new Question(R.string.question_74, 70),
            new Question(R.string.question_75, 77),
            new Question(R.string.question_76, 84),
            new Question(R.string.question_77, 64),
            new Question(R.string.question_78, 72),
            new Question(R.string.question_79, 80),
            new Question(R.string.question_80, 88),
            new Question(R.string.question_81, 96),
            new Question(R.string.question_82, 81),
            new Question(R.string.question_83, 90),
            new Question(R.string.question_84, 99),
            new Question(R.string.question_85, 108),
            new Question(R.string.question_86, 100),
            new Question(R.string.question_87, 110),
            new Question(R.string.question_88, 120),
            new Question(R.string.question_89, 121),
            new Question(R.string.question_90, 132),
            new Question(R.string.question_91, 144)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        for(int x = 0; x < newView.getNumOfQuestions(); x++) {
            submit = (Button) findViewById(R.id.submit);
            myQuestionTextView = (TextView) findViewById(R.id.question_text_view);
            question = myQuestionList[index].getMyQuestionID();
            myQuestionTextView.setText(question);
        }

        scoreTextView = (TextView) findViewById(R.id.score);
        scoreTotal = (correct + "/" + newView.getNumOfQuestions());
        scoreTextView.setText(scoreTotal);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  EditText num = findViewById(R.id.userAnswer);
                  String value = num.getText().toString();
                  int userAns = Integer.parseInt(value);
                    checkAnswer(userAns);
                    i++;

            }
        });

    }


    private void checkAnswer(int userAnswer) {
        int correctAnswer = myQuestionList[index].getMyAnswer();
        String stringAnswer = Integer.toString(correctAnswer);
        if(userAnswer != correctAnswer) {
            Toast toast = Toast.makeText(getApplicationContext(),"Correct Answer: " + stringAnswer, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 250);
            toast.show();
            startActivity(new Intent(MainGameActivity.this, IncorrectActivity.class));
        }
        else {
            correct = correct + 1;
            startActivity(new Intent(MainGameActivity.this, CorrectActivity.class));
        }
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        MainGameActivity.i = i;
    }

    public int getNumQ() {
        return NumQ;
    }

    public void setNumQ(int numQ) {
        NumQ = numQ;
    }

    public static int getCorrect() {
        return correct;
    }

    public static void setCorrect(int correct) {
        MainGameActivity.correct = correct;
    }

    public String getScoreTotal() {
        return scoreTotal;
    }
}
