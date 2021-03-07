package com.example.mytruecitizenquiz;

public class Question {

    private int questionResId;
    private boolean isAnswer;

    public Question(int questionResId, boolean isAnswer) {
        this.questionResId = questionResId;
        this.isAnswer = isAnswer;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public void setQuestionResId(int questionResId) {
        this.questionResId = questionResId;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }
}
