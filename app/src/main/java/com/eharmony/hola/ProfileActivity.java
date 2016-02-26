package com.eharmony.hola;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.eftimoff.androidplayer.Player;
import com.eftimoff.androidplayer.actions.property.PropertyAction;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        animateSampleOne(toolbar, findViewById(R.id.content_profile), fab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void animateSampleOne(View toolbar, View activityMainContentLayout, View activityMainPinkFab) {
        final PropertyAction fabAction = PropertyAction.newPropertyAction(activityMainPinkFab).scaleX(0).scaleY(0).duration(750).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction headerAction = PropertyAction.newPropertyAction(toolbar).interpolator(new DecelerateInterpolator()).translationY(-200).duration(550).alpha(0.4f).build();
        final PropertyAction bottomAction = PropertyAction.newPropertyAction(activityMainContentLayout).translationY(500).duration(750).alpha(0f).build();
        Player.init().
                animate(headerAction).
                then().
                animate(bottomAction).
                play();
    }
}
