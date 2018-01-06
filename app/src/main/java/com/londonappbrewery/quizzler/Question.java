package com.londonappbrewery.quizzler;

/**
 * Created by Ryan on 1/5/2018.
 */

public class Question {
    private int mQuestionResourceId;
    private boolean mAnswer;

    public Question(int questionResourceId, boolean answer)
    {
        mQuestionResourceId = questionResourceId;
        mAnswer = answer;
    }

    public int getQuestionResourceId() {
        return mQuestionResourceId;
    }

    public void setQuestionResourceId(int questionResourceId) {
        mQuestionResourceId = questionResourceId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }

    public String checkAnswer(boolean userAnswer)
    {
        return userAnswer == mAnswer ? "Correct" : "Wrong";
    }
}
