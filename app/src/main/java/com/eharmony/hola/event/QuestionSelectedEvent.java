package com.eharmony.hola.event;

/**
 * Created by jkang on 2/26/16.
 */
public class QuestionSelectedEvent {
    public final int id;

    public QuestionSelectedEvent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}