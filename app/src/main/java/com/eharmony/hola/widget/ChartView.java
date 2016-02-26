package com.eharmony.hola.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eharmony.hola.Model.ChartModel;
import com.eharmony.hola.R;
import com.eharmony.hola.event.ChartClickEvent;
import com.eharmony.hola.util.ChartGenerator;
import com.eharmony.hola.util.Constants;
import com.eharmony.hola.util.EventBus;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by lgarcia on 2/26/16.
 */
public class ChartView extends LinearLayout {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private ArrayList<BarEntry> yValues;
    private BarChart barChart;
    private View highestContainer;
    private View midContainer;
    private View lowContainer;
    private TextView chartHighest;
    private TextView chartMid;
    private TextView chartLow;
    // ===========================================================
    // Constructors
    // ===========================================================

    public ChartView(Context context) {
        this(context, null);
    }

    public ChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_chart, this);
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        barChart = ButterKnife.findById(this, R.id.bar_chart);
        highestContainer = ButterKnife.findById(this, R.id.highestContainer);
        midContainer = ButterKnife.findById(this, R.id.midContainer);
        lowContainer = ButterKnife.findById(this, R.id.lowContainer);
        chartHighest = ButterKnife.findById(this, R.id.chartHighest);
        chartMid = ButterKnife.findById(this, R.id.chartMid);
        chartLow = ButterKnife.findById(this, R.id.chartLow);

        init();
    }
    // ===========================================================
    // Methods
    // ===========================================================
    private void init() {
        barChart.setDescription("");
        barChart.setMaxVisibleValueCount(Constants.DIMENSIONS_COUNT);
        barChart.setPinchZoom(false);
        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);

        final XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setSpaceBetweenLabels(0);
        xAxis.setDrawGridLines(false);

        barChart.getAxisLeft().setDrawGridLines(false);

        setBarChartData();
        // add a nice and smooth animation
        barChart.animateXY(2500, 2500);

        barChart.getLegend().setEnabled(false);
    }

    private void setBarChartData() {

        yValues = ChartGenerator.INSTANCE.getChartYValues();

        final ArrayList<String> xValues = ChartGenerator.INSTANCE.getChartXValues();

        final BarDataSet set1 = new BarDataSet(yValues, "Data Set");
        set1.setColors(ChartGenerator.INSTANCE.getColors());
        set1.setDrawValues(false);

        final ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        final BarData data = new BarData(xValues, dataSets);

        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);

        barChart.setData(data);
        barChart.invalidate();

        final int[] dimens = ChartGenerator.INSTANCE.getFirstThree(yValues);

        final int highest = 0;
        final int mid = 1;
        final int low = 2;

        for (int i = 0; i < dimens.length; i++) {
            switch (i) {
                case highest:
                    chartHighest.setText(dimens[i] + "%");
                    break;
                case mid:
                    chartMid.setText(dimens[i] + "%");
                    break;
                case low:
                    chartLow.setText(dimens[i] + "%");
                    break;
            }
        }

        highestContainer.setOnClickListener(onClickListener);
        midContainer.setOnClickListener(onClickListener);
        lowContainer.setOnClickListener(onClickListener);
        barChart.setOnClickListener(onClickListener);

    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            ChartModel chartModel = null;
            int index;
            if (v == barChart) {
                index = 0;
                chartModel = new ChartModel(index, (int) yValues.get(index).getVal());
            } else if (v == highestContainer) {
                index = 0;
                chartModel = new ChartModel(index, (int) yValues.get(index).getVal());
            } else if (v == midContainer) {
                index = 1;
                chartModel = new ChartModel(index, (int) yValues.get(index).getVal());
            } else if (v == lowContainer) {
                index = 2;
                chartModel = new ChartModel(index, (int) yValues.get(index).getVal());
            }
            EventBus.INSTANCE.getBus().post(new ChartClickEvent(chartModel));
        }
    };
}
