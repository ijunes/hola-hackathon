package com.eharmony.hola.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.eharmony.hola.R;
import com.eharmony.hola.util.Anims;
import com.eharmony.hola.widget.ChartView;
import com.eharmony.hola.widget.PhotoView;
import com.github.florent37.viewanimator.ViewAnimator;

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        plus = ButterKnife.findById(view, R.id.plus);
        plus.setAlpha(0f);
        commView = ButterKnife.findById(view, R.id.comm_view);
        ChartView chartView = ButterKnife.findById(view, R.id.chart_view);
        chartView.setAlpha(0f);
        plus.setOnClickListener(onClickListener);
        commView.setOnClickListener(onClickListener);

        PhotoView photoView = ButterKnife.findById(view, R.id.photo_view);
        photoView.setAlpha(0f);

        LinearLayout profileImageTextLayout = ButterKnife.findById(view, R.id.profile_image_text_layout);
        profileImageTextLayout.setAlpha(0f);


        RelativeLayout highContainer = ButterKnife.findById(view, R.id.highestContainer);
        RelativeLayout midContainer = ButterKnife.findById(view, R.id.midContainer);
        RelativeLayout lowContainer = ButterKnife.findById(view, R.id.lowContainer);
        highContainer.setAlpha(0f);
        midContainer.setAlpha(0f);
        lowContainer.setAlpha(0f);

        ViewAnimator
                .animate(ButterKnife.findById(getActivity(), R.id.toolbar)).bounceIn().interpolator(new BounceInterpolator())
                .alpha(0,1)

                .andAnimate(profileImageTextLayout)
                .slideLeft()
                .alpha(0,1)

                .andAnimate(photoView)
                .alpha(0,1)
                .scale(1f,0.5f,1f)

                .andAnimate(plus)
                .scale(1f,0.5f,1f)
                .alpha(0,1)
                .accelerate()
                .duration(200)

                .thenAnimate(ButterKnife.findById(view, R.id.chart_view))
                .scale(1f,0.5f,1f)
                .alpha(0,1)
                .accelerate()
                .duration(200)

                .thenAnimate(highContainer)
                .alpha(0,1)
                .slideBottom()
                .accelerate().duration(100)
                .thenAnimate(midContainer)
                .alpha(0,1)
                .slideBottom()
                .accelerate().duration(100)
                .thenAnimate(lowContainer)
                .alpha(0,1)
                .slideBottom()
                .accelerate().duration(100)

                .start();
        return view;
    }
}
