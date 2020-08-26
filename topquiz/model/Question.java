package com.example.topquiz.model;

import android.content.SyncStatusObserver;

import java.util.List;

public class Question {

    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        this.setQuestion(question);
        this.setChoiceList(choiceList);
        this.setAnswerIndex(answerIndex);
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
            mQuestion = question;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        if(choiceList.size() > 0) {
            mChoiceList = choiceList;
        } else throw new IllegalArgumentException("No answer items have been found !");
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        if(answerIndex > -1 && answerIndex <= mChoiceList.size()) {
            mAnswerIndex = answerIndex;
        } else throw new IllegalArgumentException("answer index out of range !");
    }

    @Override
    public String toString() {
        return "Question{" +
                "mQuestion='" + mQuestion + '\'' +
                ", mChoiceList=" + mChoiceList +
                ", mAnswerIndex=" + mAnswerIndex +
                '}';
    }
}
