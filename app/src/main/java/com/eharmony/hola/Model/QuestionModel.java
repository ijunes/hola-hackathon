package com.eharmony.hola.model;

import android.view.animation.Animation;

/**
 * Created by hrastogi on 2/26/16.
 */
public class QuestionModel {
    int questionId;
    String questionDescription;
    Animation animation;

    public QuestionModel(int questionId, String questionDescription, final Animation animation) {
        this.questionId = questionId;
        this.questionDescription = questionDescription;
        this.animation = animation;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Animation getAnimation() {
        return this.animation;
    }
}
