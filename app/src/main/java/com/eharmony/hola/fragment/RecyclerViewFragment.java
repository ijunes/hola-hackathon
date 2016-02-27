package com.eharmony.hola.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eharmony.hola.Model.DimensionsModel;
import com.eharmony.hola.Model.GuideModel;
import com.eharmony.hola.Model.QuestionModel;
import com.eharmony.hola.R;
import com.eharmony.hola.adapter.ScoreViewAdapter;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private static final int ITEM_COUNT = 10;

    private List<Object> mContentItems = new ArrayList<>();

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        int currentPosition = getArguments().getInt("position");
        String[] questions = getResources().getStringArray(R.array.character);
        DimensionsModel model = new DimensionsModel(0, 98, "Character", "No marriage will ever thrive if one of the partners is not of “good character.”  Character, as used here, relates to one’s integrity; it has to do, primarily, with honesty.  A “character disorder,” for instance, refers to the tendency of a person to “lie, cheat, and steal” in an effort to gain personal advantage.");
        DimensionsModel model1 = new DimensionsModel(0, 78, "Sociability", "The degree to which two people both desire interpersonal relationships, and excel at them, needs to be similar for their relationship to thrive.  For instance, some persons demonstrate high attraction to other people, while others prefer to spend significantly more time alone or in just one relationship.");
        DimensionsModel model2 = new DimensionsModel(0, 74, "Ambition", "This dimension was a latecomer to our list of critical matching qualities.  It has to do with a need for stimulation, along with a personal strategy to pursue additional information through inquisitiveness.");
        DimensionsModel model3 = new DimensionsModel(0, 68, "Curiosity", "This dimension was a latecomer to our list of critical matching qualities.  It has to do with a need for stimulation, along with a personal strategy to pursue additional information through inquisitiveness.");

        ArrayList<DimensionsModel> dimensionModels = new ArrayList();

        dimensionModels.add(model);
        dimensionModels.add(model1);
        dimensionModels.add(model2);
        dimensionModels.add(model3);

        mContentItems.add(dimensionModels.get(currentPosition));

        GuideModel guideModel = new GuideModel("Guide Me!", "We have some suggestions to help you start a conversation.Select 5 to send to this match.");

        mContentItems.add(guideModel);

        for(int i=0; i<questions.length-1; i++){
            mContentItems.add(new QuestionModel(i, questions[i]));
        }

        mAdapter = new RecyclerViewMaterialAdapter(new ScoreViewAdapter(mContentItems));
        mRecyclerView.setAdapter(mAdapter);

        {
            for (int i = 0; i < ITEM_COUNT; ++i)
                mContentItems.add(new QuestionModel(i, questions[i]));
            mAdapter.notifyDataSetChanged();
        }

        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView, null);
    }
}