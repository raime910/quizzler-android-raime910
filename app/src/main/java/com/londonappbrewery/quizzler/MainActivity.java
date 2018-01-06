package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private int mCurrQuestionIdx;
    private Question mCurrQuestion;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        setCurrentQuestionText();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), mCurrQuestion.checkAnswer(true), Toast.LENGTH_SHORT).show();
                getNextQuestion();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), mCurrQuestion.checkAnswer(false), Toast.LENGTH_SHORT).show();
                getNextQuestion();
            }
        });
    }

    private void setCurrentQuestionText() {
        mCurrQuestion = mQuestionBank[mCurrQuestionIdx];
        mQuestionTextView.setText(mCurrQuestion.getQuestionResourceId());
    }

    private void getNextQuestion() {
        // validate question idx for index out of bounds.
        if (mQuestionBank.length - 1 == mCurrQuestionIdx)
        {
            mCurrQuestionIdx = 0;
        }

        mCurrQuestionIdx += 1;
        setCurrentQuestionText();
    }
}
