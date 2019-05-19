package com.example.xtable;

class Question {
    private int myQuestionID;
    private int myAnswer;

    public Question(int questionResourceID, int answer)
    {
        myQuestionID = questionResourceID;
        myAnswer = answer;
    }

    public int getMyQuestionID() {
        return myQuestionID;
    }

    public void setMyQuestionID(int myQuestionID) {
        this.myQuestionID = myQuestionID;
    }

    public int getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(int myAnswer) {
        this.myAnswer = myAnswer;
    }
}
