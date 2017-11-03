package com.celsius.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahrenheit.celsius.activities.R;
import com.celsius.dbhelper.CurrentLocationQueryResponce;
import com.celsius.dbhelper.CurrentWeatherQueryResponce;
import com.celsius.interfaces.DBHelperListenerInterface;
import com.celsius.interfaces.SpinnerInterface;
import com.celsius.services.WeatherPullService;
import com.celsius.services.WeatherPullServicePutExtraKry;
import com.celsius.utils.Tools;

import java.util.ArrayList;

/**
 * Created by dennisshar on 08/09/2017.
 */

public class MainInfoWeatherDataFragment extends Fragment {

    private DBHelperListenerInterface mCallback;
    private ArrayList<CurrentWeatherQueryResponce> currentWeatherList;
    private CurrentLocationQueryResponce currentLocationQueryResponce;

    private TextView date;
    private ImageView tempTypeIcon;
    private ImageView refreshIcon;
    private TextView hour;
    private TextView locationText;
    private ImageView searchIcon;
    private ImageView weatherVisualIndicatir;
    private TextView avgTemp;
    private TextView maxTemp;
    private TextView minTemp;
    private TextView atmosphericPressure;
    private TextView humidity;
    private TextView avgTempDescription;

    private SpinnerInterface mainSpinnerCallback;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_main_info_weather, parent, false);
        date = (TextView) view.findViewById(R.id.date);
        tempTypeIcon = (ImageView) view.findViewById(R.id.temp_type_icon);
        refreshIcon = (ImageView) view.findViewById(R.id.refresh_icon);
        hour = (TextView) view.findViewById(R.id.hour);
        locationText = (TextView) view.findViewById(R.id.location_text);
        searchIcon = (ImageView) view.findViewById(R.id.search_icon);
        weatherVisualIndicatir = (ImageView) view.findViewById(R.id.weather_visual_indicatir_icon);
        avgTemp = (TextView) view.findViewById(R.id.avg_temp);
        maxTemp = (TextView) view.findViewById(R.id.max_temp);
        minTemp = (TextView) view.findViewById(R.id.min_temp);
        atmosphericPressure = (TextView) view.findViewById(R.id.atmospheric_pressure);
        humidity = (TextView) view.findViewById(R.id.humidity);
        avgTempDescription = (TextView) view.findViewById(R.id.avg_temp_description);


        refreshIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(getActivity().getApplicationContext(), WeatherPullService.class);
                msgIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA);
                getActivity().startService(msgIntent);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DBHelperListenerInterface) activity;
        mainSpinnerCallback = (SpinnerInterface) activity;

        currentWeatherList = new ArrayList<>();
        currentWeatherList = mCallback.getDBhelper().getCurrentWeather();

        currentLocationQueryResponce = new CurrentLocationQueryResponce();
        currentLocationQueryResponce.setCity(mCallback.getDBhelper().getCurrentLocationDATA().getCity());

       // Log.e("dbquerytest","answer - > "+currentWeatherList.get(0).getHumidity());
        mainSpinnerCallback.getMainSpinner().setVisibility(View.INVISIBLE);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        date.setText(Tools.getCurrentData());
        avgTemp.setText(currentWeatherList.get(0).getTemp()+" \u2103");
        maxTemp.setText(currentWeatherList.get(0).getTemp_max()+" \u2103");//" \u2109"
        minTemp.setText(currentWeatherList.get(0).getTemp_min()+" \u2103");
        humidity.setText(currentWeatherList.get(0).getHumidity());
        atmosphericPressure.setText(currentWeatherList.get(0).getPresure());
        avgTempDescription.setText(currentWeatherList.get(0).getDescription().toUpperCase());
        weatherVisualIndicatir.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(),currentWeatherList.get(0).getIcon())));
        locationText.setText(currentLocationQueryResponce.getCity());

    }
}
