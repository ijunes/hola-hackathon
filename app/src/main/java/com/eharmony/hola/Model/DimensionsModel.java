package com.eharmony.hola.Model;

import android.view.animation.Animation;

/**
 * Created by hrastogi on 2/26/16.
 */
public class DimensionsModel {
    private int id;
    private String dimensionDescription;
    private int percentage;
    private String dimensionTitle;
    private Animation animation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPercentage(){
        return new StringBuilder().append(String.valueOf(percentage)).append("%").toString();
    }

    public String getDimensionTitle(){
        return this.dimensionTitle;
    }


    public void setTitle(String title){
        this.dimensionTitle = title;
    }

    public String getDimensionDescription(){
        return this.dimensionDescription;
    }
    public void setDimensionDescription(String dimensionDescription) {
        this.dimensionDescription = dimensionDescription;
    }

    public Animation getAnimation(){
        return this.animation;
    }
    public DimensionsModel(int id, int percentage, String dimensionTitle, String dimensionDescription, Animation animation) {
        this.id = id;
        this.percentage = percentage;
        this.dimensionTitle = dimensionTitle;
        this.dimensionDescription = dimensionDescription;
        this.animation = animation;
    }
}
