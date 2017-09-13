package com.celsius.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahrenheit.celsius.activities.R;
import com.celsius.dbhelper.FiveDaysWeatherQueryResponce;
import com.celsius.interfaces.DBHelperListenerInterface;

import java.util.ArrayList;

/**
 * Created by dennisshar on 27/08/2017.
 */

public class FIveDaysWeatherDataFragment extends Fragment{

    private DBHelperListenerInterface mCallback;
    private ArrayList<FiveDaysWeatherQueryResponce> fiveDaysWeatherList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_five_days_weather_data, parent, false);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DBHelperListenerInterface) activity;

        fiveDaysWeatherList = new ArrayList<>();
        fiveDaysWeatherList = mCallback.getDBhelper().getFiveDaysWeather();

    }

}
