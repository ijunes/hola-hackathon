package com.eharmony.hola.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.eharmony.hola.R;

/**
 * Created by jkang on 2/26/16.
 */
public class DimensionViewHolder extends RecyclerView.ViewHolder {

    public TextView questionTextView;
    static final int TYPE_HEADER = 0;
    static final int TYPE_GUIDE_CELL = 1;
    static final int TYPE_CELL = 2;
    public DimensionViewHolder(View itemView, int viewType) {
        super(itemView);

        if(viewType == TYPE_HEADER){

        }

        if(viewType == TYPE_GUIDE_CELL){

        }
        if(viewType == TYPE_CELL)
        questionTextView = ((TextView) itemView.findViewById(R.id.questionText));
    }

    private void initHeader(){

    }

    private void initGuide(){

    }

    private void  initCell(){

    }

}
