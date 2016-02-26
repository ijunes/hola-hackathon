package com.eharmony.hola.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.eharmony.hola.Model.DimensionsModel;
import com.eharmony.hola.Model.GuideModel;
import com.eharmony.hola.Model.QuestionModel;
import com.eharmony.hola.R;
import com.eharmony.hola.event.QuestionSelectedEvent;
import com.eharmony.hola.util.EventBus;
import com.eharmony.hola.views.DimensionViewHolder;

import java.util.List;

/**
 * Created by ijunes on 2/25/2016.
 */
public class ScoreViewAdapter extends RecyclerView.Adapter<DimensionViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_GUIDE_CELL = 1;
    static final int TYPE_CELL = 2;

    public ScoreViewAdapter(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            case 1:
               return  TYPE_GUIDE_CELL;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public DimensionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_item_large, parent, false);
                return new DimensionViewHolder(view, viewType) {
                };
            }
            case TYPE_GUIDE_CELL:{
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_item_medium, parent, false);
                return new DimensionViewHolder(view, viewType) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_item_small, parent, false);
                return new DimensionViewHolder(view, viewType) {
                };
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(DimensionViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                DimensionsModel dimensionsModel = (DimensionsModel) contents.get(position);
                holder.percentTextView.setText(dimensionsModel.getPercentage());
                holder.titleTextView.setText(dimensionsModel.getDimensionTitle());
                holder.dimensionTextView.setText(dimensionsModel.getDimensionDescription());
                break;
            case TYPE_GUIDE_CELL:
                GuideModel guideModel = (GuideModel) contents.get(position);
                holder.guidemeTextView.setText(guideModel.getGuideTitle());
                holder.guidemeDetailsTextView.setText(guideModel.getGuideText());
                break;
            case TYPE_CELL:
                final QuestionModel questionModel = (QuestionModel) contents.get(position);
                holder.questionTextView.setText(questionModel.getQuestionDescription());
                holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        EventBus.INSTANCE.getBus().post(new QuestionSelectedEvent(questionModel.getQuestionId()));
                    }
                });
                break;
        }
    }



}