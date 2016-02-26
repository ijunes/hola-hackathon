package com.eharmony.hola.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.eharmony.hola.R;

/**
 * Created by jkang on 2/26/16.
 */
public class QuestionViewHolder extends RecyclerView.ViewHolder {

    public TextView questionTextView;
    public QuestionViewHolder(View itemView) {
        super(itemView);
        questionTextView = ((TextView) itemView.findViewById(R.id.questionText));
    }
}
