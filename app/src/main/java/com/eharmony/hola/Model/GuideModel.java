package com.eharmony.hola.Model;

/**
 * Created by jkang on 2/26/16.
 */
public class GuideModel {
    String guideTitle;
    String guideText;

    public GuideModel(final String guideTitle, final String guideText){
        this.guideTitle = guideTitle;
        this.guideText = guideText;
    }

    public String getGuideTitle(){
        return this.guideTitle;
    }

    public String getGuideText(){
        return this.guideText;
    }

}
