package com.eharmony.hola.widgets;

import android.app.Activity;
import android.os.Handler;


import mbanje.kurt.fabbutton.FabButton;

public class ProgressHelper {

    private int currentProgress = 0;
    private Handler handle=new Handler();
    private final FabButton button;
    private final Activity activity;

    public ProgressHelper(FabButton button, Activity activity) {
        this.button = button;
        this.activity = activity;
    }

    private Runnable getRunnable(final Activity activity, final int delta){
        return new Runnable() {
            @Override
            public void run() {
                currentProgress += delta;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button.setProgress(currentProgress);
                        if(currentProgress == 100){
                            startIndeterminate();
                        }
                    }
                });
            }
        };
    }


    public void startIndeterminate() {
        button.showProgress(true);
    }

    public void startDeterminate() {
        button.resetIcon();
        currentProgress = 0;
        button.showProgress(true);
        button.setProgress(currentProgress);
        getRunnable(activity, 0).run();
    }

    public void incrementCount(){
        getRunnable(activity, 20).run();
    }

    public void decrementCount(){
        getRunnable(activity, -20).run();
    }


}