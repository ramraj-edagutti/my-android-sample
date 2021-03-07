package com.example.mytruecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton prevButton;

    private TextView questionTextView;

    private int questionIndex = 0;

    private Question[] questions = new Question[] {
            new Question(R.string.question_text_1_view, true),
            new Question(R.string.question_text_2_view, false),
            new Question(R.string.question_text_3_view, true),
            new Question(R.string.question_text_4_view, true),
            new Question(R.string.question_text_5_view, false),
            new Question(R.string.question_text_6_view, true),
            new Question(R.string.question_text_7_view, false),
            new Question(R.string.question_text_8_view, true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.button_true);
        falseButton = findViewById(R.id.button_false);
        nextButton = findViewById(R.id.button_next);
        prevButton = findViewById(R.id.button_prev);

        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_true:
                checkQuestion(true);
                break;
            case R.id.button_false:
                checkQuestion(false);
                break;
            case R.id.button_next:
                Log.d("Question Index", String.valueOf(questionIndex));
                questionIndex = (questionIndex + 1) % questions.length;
                Log.d("Question Next Index", String.valueOf(questionIndex));
                updateQuestion();
                break;
            case R.id.button_prev:
                Log.d("Question Index", String.valueOf(questionIndex));
                if (questionIndex == 0) {
                    questionIndex = (questions.length -1);
                } else {
                    questionIndex = (questionIndex - 1) % questions.length;
                }
                Log.d("Question Prev Index", String.valueOf(questionIndex));
                updateQuestion();


        }
    }

    private void updateQuestion() {
        questionTextView.setText(questions[questionIndex].getQuestionResId());
    }

    private void checkQuestion(boolean isAnswered) {
        boolean isAnswer = questions[questionIndex].isAnswer();

        String toastMsg = "You are Correct!";
        if (isAnswer != isAnswered) {
            toastMsg = "You are Wrong!";
        }
        Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();
    }
}