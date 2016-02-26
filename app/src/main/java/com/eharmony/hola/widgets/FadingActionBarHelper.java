package com.eharmony.hola.widgets;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;

public class FadingActionBarHelper {
    private static final String TAG = "FadingActionBarHelper";
    private int mAlpha = 255;
    private Drawable mDrawable;
    private boolean isAlphaLocked;
    private final ActionBar mActionBar;

    public FadingActionBarHelper(ActionBar actionBar) {
        this.mActionBar = actionBar;
    }

    public FadingActionBarHelper(ActionBar actionBar, Drawable drawable) {
        this.mActionBar = actionBar;
        this.setActionBarBackgroundDrawable(drawable);
    }

    public void setActionBarBackgroundDrawable(Drawable drawable) {
        this.setActionBarBackgroundDrawable(drawable, true);
    }

    public void setActionBarBackgroundDrawable(Drawable drawable, boolean mutate) {
        this.mDrawable = mutate?drawable.mutate():drawable;
        this.mActionBar.setBackgroundDrawable(this.mDrawable);
        if(this.mAlpha == 255) {
            if(VERSION.SDK_INT >= 19) {
                this.mAlpha = this.mDrawable.getAlpha();
            }
        } else {
            this.setActionBarAlpha(this.mAlpha);
        }

    }

    public Drawable getActionBarBackgroundDrawable() {
        return this.mDrawable;
    }

    public void setActionBarAlpha(int alpha) {
        if(this.mDrawable == null) {
            Log.w("FadingActionBarHelper", "Set action bar background before setting the alpha level!");
        } else {
            if(!this.isAlphaLocked) {
                this.mDrawable.setAlpha(alpha);
            }

            this.mAlpha = alpha;
        }
    }

    public int getActionBarAlpha() {
        return this.mAlpha;
    }

    public void setActionBarAlphaLocked(boolean lock) {
        if(this.isAlphaLocked != (this.isAlphaLocked = lock) && !this.isAlphaLocked) {
            this.setActionBarAlpha(this.mAlpha);
        }

    }

    public boolean isActionBarAlphaLocked() {
        return this.isAlphaLocked;
    }
}
