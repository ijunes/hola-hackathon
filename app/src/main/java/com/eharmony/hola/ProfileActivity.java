package com.eharmony.hola;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.eharmony.hola.event.ChartClickEvent;
import com.eharmony.hola.fragment.ProfileFragment;
import com.eharmony.hola.util.Constants;
import com.eharmony.hola.util.EventBus;
import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {
// ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private Toolbar toolbar;
    // ===========================================================
    // Constructors
    // ===========================================================
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from Supeactivity_mains
    // ===========================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = ButterKnife.findById(this, R.id.toolbar);
        setupToolbarInfo();
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setBackgroundColor(Color.argb(192, 255, 255, 255));

        addFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.like:

                return true;
            case R.id.hide:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    // ===========================================================
    // Methods
    // ===========================================================
    private void addFragment() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        final ProfileFragment profileFragment = new ProfileFragment();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.add(R.id.frame_container, profileFragment, ProfileFragment.TAG);
        fragmentTransaction.commit();
    }

    private void setupToolbarInfo() {
        final Resources res = getResources();
        toolbar.setTitle(res.getString(R.string.user_name));
        toolbar.setSubtitle(res.getString(R.string.user_area));
    }

    @Subscribe
    public void startCardActivity(final ChartClickEvent chartClickEvent) {
        if (chartClickEvent != null) {
            final Intent intent = new Intent(ProfileActivity.this, ScoreActivity.class);
            intent.putExtra(Constants.CHART_BUNDLE, chartClickEvent.getChartModel());
            startActivity(intent);
        }
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
