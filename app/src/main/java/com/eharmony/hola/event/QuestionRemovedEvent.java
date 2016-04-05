package com.eharmony.hola.event;

/**
 * Created by jkang on 2/26/16.
 */
public class QuestionRemovedEvent {
    public final int id;

    public QuestionRemovedEvent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}