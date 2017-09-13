package com.celsius.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahrenheit.celsius.activities.R;
import com.celsius.dbhelper.CurrentWeatherQueryResponce;
import com.celsius.interfaces.DBHelperListenerInterface;

import java.util.ArrayList;

/**
 * Created by dennisshar on 27/08/2017.
 */

public class ThreeDaysWeatherDataFragment extends Fragment{


    private DBHelperListenerInterface mCallback;
    private ArrayList<CurrentWeatherQueryResponce> currentWeatherList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_three_days_weather_data, parent, false);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DBHelperListenerInterface) activity;

        currentWeatherList = new ArrayList<>();
        currentWeatherList = mCallback.getDBhelper().getCurrentWeather();

        //Log.e("dbquerytest","answer - > "+currentWeatherList.get(0).getHumidity());

    }


}
