package com.eharmony.hola.Model;

/**
 * Created by hrastogi on 2/26/16.
 */
public class QuestionModel {
    int questionId;
    String questionDescription;

    public QuestionModel(int questionId, String questionDescription) {
        this.questionId = questionId;
        this.questionDescription = questionDescription;
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
}
