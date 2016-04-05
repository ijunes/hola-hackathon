package com.eharmony.hola.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eharmony.hola.R;

/**
 * Created by jkang on 2/26/16.
 */
public class DimensionViewHolder extends RecyclerView.ViewHolder {

    static final int TYPE_HEADER = 0;
    static final int TYPE_GUIDE_CELL = 1;
    static final int TYPE_CELL = 2;
    public RelativeLayout mainLayout;
    public TextView percentTextView;
    public TextView titleTextView;
    public TextView dimensionTextView;
    public TextView guidemeTextView;
    public TextView guidemeDetailsTextView;
    public TextView questionTextView;
    public CheckBox checkbox;

    public DimensionViewHolder(View itemView, int viewType) {
        super(itemView);

        if (viewType == TYPE_HEADER) {
            mainLayout = (RelativeLayout) itemView.findViewById(R.id.main_dimension_container);
            percentTextView = (TextView) itemView.findViewById(R.id.dimension_percentage_textview);
            titleTextView = (TextView) itemView.findViewById(R.id.dimension_title_textview);
            dimensionTextView = (TextView) itemView.findViewById(R.id.dimension_desc_textview);
        }

        if (viewType == TYPE_GUIDE_CELL) {
            guidemeTextView = (TextView) itemView.findViewById(R.id.guideme_textview);
            guidemeDetailsTextView = (TextView) itemView.findViewById(R.id.guideme_detail_textview);
        }
        if (viewType == TYPE_CELL) {
            questionTextView = ((TextView) itemView.findViewById(R.id.questionText));
            checkbox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }


}
