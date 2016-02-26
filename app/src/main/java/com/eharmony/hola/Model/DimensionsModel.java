package com.eharmony.hola.Model;

/**
 * Created by hrastogi on 2/26/16.
 */
public class DimensionsModel {
   int id;
    String questionDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public DimensionsModel(int id, String questionDescription) {
        this.id = id;
        this.questionDescription = questionDescription;
    }
}
