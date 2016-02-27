package com.eharmony.hola.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;

import com.eharmony.hola.R;
import com.eharmony.hola.util.Anims;
import com.eharmony.hola.util.EventBus;

import butterknife.ButterKnife;

/**
 * Created by lgarcia on 2/26/16.
 */
public class ProfileFragment extends Fragment {
    // ===========================================================
    // Constants
    // ===========================================================
    public static final String TAG = ProfileFragment.class.getName();
    // ===========================================================
    // Fields
    // ===========================================================
    private View view;
    private ImageButton plus;
    private View commView;
    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        plus = ButterKnife.findById(view, R.id.plus);
        commView = ButterKnife.findById(view, R.id.comm_view);

        plus.setOnClickListener(onClickListener);
        commView.setOnClickListener(onClickListener);

        return view;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == plus) {
                plus.setVisibility(View.GONE);
                commView.setVisibility(View.VISIBLE);
            } else if (v == commView) {
                plus.setVisibility(View.VISIBLE);
                commView.setVisibility(View.GONE);
                Anims.INSTANCE.translateDown(plus);
            }
        }
    };
}
