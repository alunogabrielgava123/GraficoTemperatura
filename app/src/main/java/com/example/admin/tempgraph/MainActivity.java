package com.example.admin.tempgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private LineChart mChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChart = (LineChart) findViewById(R.id.Linechart);

        //mChart.setOnChartGestureListener(MainActivity.this);
        //mChart.setOnChartValueSelectedListener(MainActivity.this);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setPinchZoom(true);
        mChart.setDoubleTapToZoomEnabled(true);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.enableGridDashedLine(10f, 10f, 0);
        leftAxis.setDrawLimitLinesBehindData(true);

        mChart.getAxisRight().setEnabled(true);// Desabilita ou habilita o eixo da direita


        // Adicionar valores x e y ao gráfico para temperatura do ar

        ArrayList<Entry> yValue1 = new ArrayList<>();

        yValue1.add(new Entry(1, 20f));
        yValue1.add(new Entry(2, 30f));
        yValue1.add(new Entry(3, 40f));
        yValue1.add(new Entry(4, 50f));
        yValue1.add(new Entry(5, -10f));
        yValue1.add(new Entry(6, 15f));

        LineDataSet set1 = new LineDataSet(yValue1, "Temperatura do ar (C)");

        set1.setFillAlpha(110);

        set1.setColor(Color.BLACK);
        set1.setLineWidth(3f);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(Color.BLACK);
        set1.setHighLightColor(Color.BLACK);//muda a cor da linha de grade

        // Adicionar valores de umidade relativa no eixo secundário


        ArrayList<Entry> yValue2 = new ArrayList<>();

        yValue2.add(new Entry(1, 30f));
        yValue2.add(new Entry(2, 10f));
        yValue2.add(new Entry(3, 20f));
        yValue2.add(new Entry(4, 40f));
        yValue2.add(new Entry(5, 10f));
        yValue2.add(new Entry(6, 15f));

        LineDataSet set2 = new LineDataSet(yValue2, "Umidade Relativa do ar (%)");

        set2.setFillAlpha(110);

        set2.setColor(Color.BLUE);
        set2.setLineWidth(3f);
        set2.setValueTextSize(10f);
        set2.setValueTextColor(Color.BLUE);
        set2.setHighLightColor(Color.BLUE);

        //Formatar legenda

        Legend leg1 = mChart.getLegend();
        leg1.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);

        LineData data = new LineData(dataSets);


        mChart.setData(data);

        String[] values = new String[]{"Jan", "Fev", "Mar", "Apr", "Mai", "Jun"};

        XAxis xAxis = mChart.getXAxis();
        //xAxis.setValueFormatter(new MyAxisValueFormatter(values));
        xAxis.setGranularity(1);
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
    }
}
