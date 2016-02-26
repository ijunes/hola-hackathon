package com.eharmony.hola.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.eharmony.hola.R;
import com.eharmony.hola.util.ChartGenerator;
import com.eharmony.hola.util.Constants;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
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
    private BarChart barChart;
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
        barChart.animateY(2500);

        barChart.getLegend().setEnabled(false);
    }

    private void setBarChartData() {

        final ArrayList<BarEntry> yValues = ChartGenerator.INSTANCE.getChartYValues();

        final ArrayList<String> xValues = ChartGenerator.INSTANCE.getChartXValues();

        final BarDataSet set1 = new BarDataSet(yValues, "Data Set");
        set1.setColors(ChartGenerator.INSTANCE.getColors());
        set1.setDrawValues(false);

        final ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        final BarData data = new BarData(xValues, dataSets);

        barChart.setData(data);
        barChart.invalidate();
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
