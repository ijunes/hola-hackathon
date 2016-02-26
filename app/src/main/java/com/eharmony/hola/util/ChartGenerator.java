package com.eharmony.hola.util;

import android.graphics.Color;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by lgarcia on 2/26/16.
 */
public enum ChartGenerator {
    INSTANCE;

    public ArrayList<BarEntry> getChartYValues() {
        final ArrayList<Integer> xValues = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < Constants.DIMENSIONS_COUNT; i++) {
            xValues.add(random.nextInt(100) + 1);
        }

        Collections.sort(xValues);
        Collections.reverse(xValues);

        final ArrayList<BarEntry> chartValues = new ArrayList<>();
        for (int i = 0; i < xValues.size(); i++) {
            chartValues.add(new BarEntry(xValues.get(i), i));
        }
        return chartValues;
    }

    public ArrayList<String> getChartXValues() {
        final ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < Constants.DIMENSIONS_COUNT; i++) {
            xValues.add("");
        }
        return xValues;
    }

    public int[] getColors() {
        final int[] colors = new int[Constants.DIMENSIONS_COUNT];

        final int highest = 0;
        final int mid = 1;
        final int low = 2;

        for (int i = 0; i < Constants.DIMENSIONS_COUNT; i++) {
            switch (i) {
                case highest:
                    colors[i] = Color.rgb(143, 180, 62);
                    break;
                case mid:
                    colors[i] = Color.rgb(50, 138, 161);
                    break;
                case low:
                    colors[i] = Color.rgb(24, 87, 114);
                    break;
                default:
                    colors[i] = Color.argb(25, 74, 74, 74);
                    break;
            }
        }

        return colors;
    }

}
