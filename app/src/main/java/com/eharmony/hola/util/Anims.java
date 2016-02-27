package com.eharmony.hola.util;

import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.eftimoff.androidplayer.actions.property.PropertyAction;

/**
 * Created by lgarcia on 2/26/16.
 */
public enum Anims {

    INSTANCE;

    public void translateDown(View view) {
        final PropertyAction headerAction = PropertyAction.newPropertyAction(view).
                interpolator(new DecelerateInterpolator()).
                translationY(-200).
                duration(550).
                alpha(0.4f).
                build();

        headerAction.animate(view);
    }

}
