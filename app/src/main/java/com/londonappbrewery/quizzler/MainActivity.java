package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here

    // TODO: Declare member variables here:
    private Button mTrueButton;
    private Button mFalseButton;
    private ProgressBar mProgressBar;
    private TextView mScore;

    private int mCurrQuestionIdx;
    private TextView mQuestionTextView;
    private Question mCurrQuestion;

    private int mCorrectAnswers = 0;

    // TODO: Uncomment to create question bank
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_1, true),
            new Question(R.string.question_2, true),
            new Question(R.string.question_3, true),
            new Question(R.string.question_4, true),
            new Question(R.string.question_5, true),
            new Question(R.string.question_6, false),
            new Question(R.string.question_7, true),
            new Question(R.string.question_8, false),
            new Question(R.string.question_9, true),
            new Question(R.string.question_10, true),
            new Question(R.string.question_11, false),
            new Question(R.string.question_12, false),
            new Question(R.string.question_13, true)
    };

    final private int PROGRESSBAR_INCREMENT = (int) Math.ceil(100.0 / mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mScore = (TextView) findViewById(R.id.score);

        updateScore(false);
        setCurrentQuestionText();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), checkAnswer(true), Toast.LENGTH_SHORT).show();
                getNextQuestion();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), checkAnswer(false), Toast.LENGTH_SHORT).show();
                getNextQuestion();
            }
        });
    }

    private String checkAnswer(boolean answer) {
        String result = "Wrong!";
        boolean isCorrect = mCurrQuestion.isAnswer() == answer;

        if (isCorrect) {
            result = "You got it!";
        }

        // update progressbar
        updateProgressBar();

        // update score
        updateScore(isCorrect);

        return result;
    }

    private void updateProgressBar() {
        mProgressBar.setProgress(PROGRESSBAR_INCREMENT * (mCurrQuestionIdx + 1));
    }

    private void updateScore(boolean isCorrect) {
        if (isCorrect) {
            mCorrectAnswers += 1;
        }
        mScore.setText(mCorrectAnswers + "/" + mQuestionBank.length);
    }

    private void setCurrentQuestionText() {
        mCurrQuestion = mQuestionBank[mCurrQuestionIdx];
        mQuestionTextView.setText(mCurrQuestion.getQuestionResourceId());
    }

    private void getNextQuestion() {
        // validate question idx for index out of bounds.
        if (mQuestionBank.length - 1 == mCurrQuestionIdx) {
            mCurrQuestionIdx = 0;
        }

        mCurrQuestionIdx += 1;
        setCurrentQuestionText();
    }

    private void reset()
    {
        mCorrectAnswers = 0;

    }

}
