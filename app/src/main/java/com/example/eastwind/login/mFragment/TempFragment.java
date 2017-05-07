package com.example.eastwind.login.mFragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eastwind.login.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Niroshana on 5/1/2017.
 */

public class TempFragment extends Fragment{

    private String API_KEY = "21vCrRxRAFYrGxGQvgyxRAB34NdeW5";
    private String tempVarId = "58fcd51c7625420d81431d43";
    private LineChart tempChart;

    Flag tempFlag = new Flag();







    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public TempFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.temperature_fragment,container,false);
        tempChart = (LineChart) v.findViewById(R.id.chartTemperature);

        initTempChart(tempChart);


        //Temperature


        ( new UbidotsClient() ).handleUbidots(tempVarId, API_KEY, new UbidotsClient.UbiListener() {
            @Override
            public void onDataReady(List<UbidotsClient.Value> result) {
                Log.d("Chart", "======== On data Ready ===========");
                List<Entry> entries = new ArrayList();
                List<String> labels = new ArrayList<String>();
                for (int i = 0; i < result.size(); i++) {

                    Entry be = new Entry(result.get(i).value, i);
                    entries.add(be);
                    Log.d("Chart", be.toString());
                    // Convert timestamp to date
                    Date d = new Date(result.get(i).timestamp);
                    // Create Labels
                    labels.add(sdf.format(d));
                    //create status bar update
                    if(entries.get(i).getVal() > 25){
                        tempFlag.setTempFlag(1);
                    }else {
                        tempFlag.setTempFlag(2);
                    }




                }






                LineDataSet ld = new LineDataSet(entries, "Temperature");

                ld.setDrawHighlightIndicators(false);
                ld.setDrawValues(true);
                ld.setColor(Color.GREEN);
                ld.setCircleColor(Color.GREEN);
                ld.setLineWidth(1f);
                ld.setCircleSize(3f);
                ld.setDrawCircleHole(false);
                ld.setFillAlpha(65);
                ld.setFillColor(Color.GREEN);
                ld.setDrawCubic(true);
                ld.setDrawFilled(true);
                ld.setHighlightEnabled(true);



                LineData lineData = new LineData(labels, ld);
                tempChart.setData(lineData);


                if (getActivity() != null) {
                    Handler handler = new Handler(TempFragment.this.getActivity().getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tempChart.invalidate();
                        }
                    });

                }
            }
            
        });

        return v;




    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void initTempChart(LineChart chart) {
        chart.setTouchEnabled(true);
        chart.setDrawGridBackground(false);
        chart.getAxisRight().setEnabled(false);
        chart.setScaleMinima(10f,5f);
        chart.animateY(3000);


        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMaxValue(1000F);
        leftAxis.setAxisMinValue(10F);
        leftAxis.setStartAtZero(false);
        leftAxis.setAxisLineWidth(2);
        leftAxis.setDrawGridLines(true);




        // X-Axis
        XAxis xAxis = chart.getXAxis();
        xAxis.resetLabelsToSkip();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);




    }

}
