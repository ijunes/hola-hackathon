package com.eharmony.hola.Model;

import android.view.animation.Animation;

/**
 * Created by jkang on 2/26/16.
 */
public class GuideModel {
    String guideTitle;
    String guideText;
    Animation animation;
    public GuideModel(final String guideTitle, final String guideText, final Animation animation){
        this.guideTitle = guideTitle;
        this.guideText = guideText;
        this.animation = animation;
    }

    public String getGuideTitle(){
        return this.guideTitle;
    }

    public String getGuideText(){
        return this.guideText;
    }
    public Animation getAnimation(){
        return this.animation;
    }

}
