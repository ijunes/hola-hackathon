package com.eharmony.hola.event;

import com.eharmony.hola.model.ChartModel;

/**
 * Created by lgarcia on 2/26/16.
 */
public class ChartClickEvent {
    private final ChartModel chartModel;

    public ChartClickEvent(ChartModel chartModel) {
        this.chartModel = chartModel;
    }

    public ChartModel getChartModel() {
        return chartModel;
    }
}
