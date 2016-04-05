package com.eharmony.hola;

import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.eharmony.hola.event.QuestionRemovedEvent;
import com.eharmony.hola.event.QuestionSelectedEvent;
import com.eharmony.hola.fragment.ScoreFragment;
import com.eharmony.hola.util.EventBus;
import com.eharmony.hola.widget.ProgressHelper;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.squareup.otto.Subscribe;

import mbanje.kurt.fabbutton.FabButton;

public class ScoreActivity extends AppCompatActivity {
    private ProgressHelper helper;
    private MaterialViewPager viewPager;
    private AdapterView.OnItemSelectedListener questionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        initActivity();
    }

    @Subscribe
    public void questionSelected(QuestionSelectedEvent event) {
        helper.incrementCount();
    }

    @Subscribe
    public void questionRemoved(QuestionRemovedEvent event) {
        helper.decrementCount();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            EventBus.INSTANCE.getBus().register(this);
        } catch (Exception e) {
            Log.e(ProfileActivity.class.getName(), e.getMessage(), e);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            EventBus.INSTANCE.getBus().unregister(this);
        } catch (Exception e) {
            Log.e(ProfileActivity.class.getName(), e.getMessage(), e);
        }
    }

    private void initActivity(){
        final String[] dimensions = getResources().getStringArray(R.array.dimensions);
        viewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        Toolbar toolbar = viewPager.getToolbar();
        if (toolbar != null) {
            toolbar.setTitle("Justin");

            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);

            final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
            actionBar.setHomeAsUpIndicator(upArrow);

            actionBar.setHomeButtonEnabled(true);
        }

        viewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    //case 0:
                    //    return ScoreFragment.newInstance();
                    //case 1:
                    //    return ScoreFragment.newInstance();
                    //case 2:
                    //    return WebViewFragment.newInstance();
                    default:
                        ScoreFragment fragment = ScoreFragment.newInstance();
                        Bundle bundle = new Bundle();
                        bundle.putInt("position", position);
                        fragment.setArguments(bundle);
                        return fragment;
                }
            }

            @Override
            public int getCount() {
                return dimensions.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return dimensions[position % dimensions.length];
            }
        });

        viewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {

                ColorDrawable colorDrawable = new ColorDrawable(0xFFFFFF);
                return HeaderDesign.fromColorResAndDrawable(R.color.colorWhite, colorDrawable);
            }
        });


        viewPager.getViewPager().setOffscreenPageLimit(viewPager.getViewPager().getAdapter().getCount());
        viewPager.getPagerTitleStrip().setViewPager(viewPager.getViewPager());
        final View.OnClickListener fabListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        final FabButton button = (FabButton) findViewById(R.id.determinate);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        helper = new ProgressHelper(button, this);

        button.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View v) {
                EventBus.INSTANCE.getBus().post(new QuestionSelectedEvent(1));
                count++;
            }
        });
    }
}
