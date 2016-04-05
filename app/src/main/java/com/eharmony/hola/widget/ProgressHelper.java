package com.eharmony.hola.widget;

import android.app.Activity;
import android.os.Handler;

import mbanje.kurt.fabbutton.FabButton;

public class ProgressHelper {

    private final FabButton button;
    private final Activity activity;
    private int currentProgress = 0;
    private Handler handle = new Handler();

    public ProgressHelper(FabButton button, Activity activity) {
        this.button = button;
        this.activity = activity;
    }

    private Runnable getRunnable(final Activity activity, final int delta) {
        return new Runnable() {
            @Override
            public void run() {
                if (delta >= 0) {
                    currentProgress += delta;
                } else {
                    currentProgress -= 20;
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button.setProgress(currentProgress);
                        if (currentProgress == 100) {
                            startIndeterminate();
                        } else if (currentProgress > 110) {
                            button.onProgressCompleted();
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

    public void incrementCount() {
        if (currentProgress == 0) {
            startDeterminate();
        }
        getRunnable(activity, 20).run();
    }

    public void decrementCount() {
        getRunnable(activity, -20).run();
    }


}