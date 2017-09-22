package com.celsius.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahrenheit.celsius.activities.R;
import com.celsius.dbhelper.FiveDaysWeatherQueryResponce;
import com.celsius.interfaces.DBHelperListenerInterface;
import com.celsius.utils.Tools;

import java.util.ArrayList;

/**
 * Created by dennisshar on 27/08/2017.
 */

public class FIveDaysWeatherDataFragment extends Fragment{

    private DBHelperListenerInterface mCallback;
    private ArrayList<FiveDaysWeatherQueryResponce> fiveDaysWeatherList;
    private ArrayList<FiveDaysWeatherQueryResponce> onlyFiveDaysWeatherList;


    private TextView day_one_name;
    private TextView day_one_date;
    private ImageView day_one_wheather_indicator_icon;
    private TextView day_one_weather_discription;
    private TextView day_one_min_max_temp;

    private TextView day_two_name;
    private TextView day_two_date;
    private ImageView day_two_wheather_indicator_icon;
    private TextView day_two_weather_discription;
    private TextView day_two_min_max_temp;

    private TextView day_three_name;
    private TextView day_three_date;
    private ImageView day_three_wheather_indicator_icon;
    private TextView day_three_weather_discription;
    private TextView day_three_min_max_temp;

    private TextView day_four_name;
    private TextView day_four_date;
    private ImageView day_four_wheather_indicator_icon;
    private TextView day_four_weather_discription;
    private TextView day_four_min_max_temp;

    private TextView day_five_name;
    private TextView day_five_date;
    private ImageView day_five_wheather_indicator_icon;
    private TextView day_five_weather_discription;
    private TextView day_five_min_max_temp;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_five_days_weather_data, parent, false);


        day_one_name = (TextView) view.findViewById(R.id.day_one_name);
        day_one_date = (TextView) view.findViewById(R.id.day_one_date);
        day_one_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_one_wheather_indicator_icon);
        day_one_weather_discription = (TextView) view.findViewById(R.id.day_one_weather_discription);
        day_one_min_max_temp = (TextView) view.findViewById(R.id.day_one_min_max_temp);

        day_two_name = (TextView) view.findViewById(R.id.day_two_name);
        day_two_date = (TextView) view.findViewById(R.id.day_two_date);
        day_two_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_two_wheather_indicator_icon);
        day_two_weather_discription = (TextView) view.findViewById(R.id.day_two_weather_discription);
        day_two_min_max_temp = (TextView) view.findViewById(R.id.day_two_min_max_temp);

        day_three_name = (TextView) view.findViewById(R.id.day_three_name);
        day_three_date = (TextView) view.findViewById(R.id.day_three_date);
        day_three_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_three_wheather_indicator_icon);
        day_three_weather_discription = (TextView) view.findViewById(R.id.day_three_weather_discription);
        day_three_min_max_temp = (TextView) view.findViewById(R.id.day_three_min_max_temp);

        day_four_name = (TextView) view.findViewById(R.id.day_four_name);
        day_four_date = (TextView) view.findViewById(R.id.day_four_date);
        day_four_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_four_wheather_indicator_icon);
        day_four_weather_discription = (TextView) view.findViewById(R.id.day_four_weather_discription);
        day_four_min_max_temp = (TextView) view.findViewById(R.id.day_four_min_max_temp);

        day_five_name = (TextView) view.findViewById(R.id.day_five_name);
        day_five_date = (TextView) view.findViewById(R.id.day_five_date);
        day_five_wheather_indicator_icon = (ImageView) view.findViewById(R.id.day_five_wheather_indicator_icon);
        day_five_weather_discription = (TextView) view.findViewById(R.id.day_five_weather_discription);
        day_five_min_max_temp = (TextView) view.findViewById(R.id.day_five_min_max_temp);


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DBHelperListenerInterface) activity;

        fiveDaysWeatherList = new ArrayList<>();
        fiveDaysWeatherList = mCallback.getDBhelper().getFiveDaysWeather();
        onlyFiveDaysWeatherList = Tools.filteredList(fiveDaysWeatherList,5);

    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        day_one_name.setText(Tools.dayNameFromTimeStamp(onlyFiveDaysWeatherList.get(0).getDt()));
        day_one_date.setText(Tools.dateFromTimeStamp(onlyFiveDaysWeatherList.get(0).getDt()));
        day_one_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(),onlyFiveDaysWeatherList.get(0).getIcon())));
        day_one_weather_discription.setText(onlyFiveDaysWeatherList.get(0).getDescription().toUpperCase());
        day_one_min_max_temp.setText(onlyFiveDaysWeatherList.get(0).getTemp_max()+"\u2103"+" / "+onlyFiveDaysWeatherList.get(0).getTemp_min().toUpperCase()+"\u2103");

        day_two_name.setText(Tools.dayNameFromTimeStamp(onlyFiveDaysWeatherList.get(1).getDt()));
        day_two_date.setText(Tools.dateFromTimeStamp(onlyFiveDaysWeatherList.get(1).getDt()));
        day_two_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(),onlyFiveDaysWeatherList.get(1).getIcon())));
        day_two_weather_discription.setText(onlyFiveDaysWeatherList.get(1).getDescription().toUpperCase());
        day_two_min_max_temp.setText(onlyFiveDaysWeatherList.get(1).getTemp_max()+"\u2103"+" / "+onlyFiveDaysWeatherList.get(1).getTemp_min().toUpperCase()+"\u2103");

        day_three_name.setText(Tools.dayNameFromTimeStamp(onlyFiveDaysWeatherList.get(2).getDt()));
        day_three_date.setText(Tools.dateFromTimeStamp(onlyFiveDaysWeatherList.get(2).getDt()));
        day_three_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(),onlyFiveDaysWeatherList.get(2).getIcon())));
        day_three_weather_discription.setText(onlyFiveDaysWeatherList.get(2).getDescription().toUpperCase());
        day_three_min_max_temp.setText(onlyFiveDaysWeatherList.get(2).getTemp_max()+"\u2103"+" / "+onlyFiveDaysWeatherList.get(2).getTemp_min().toUpperCase()+"\u2103");

        day_four_name.setText(Tools.dayNameFromTimeStamp(onlyFiveDaysWeatherList.get(3).getDt()));
        day_four_date.setText(Tools.dateFromTimeStamp(onlyFiveDaysWeatherList.get(3).getDt()));
        day_four_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(),onlyFiveDaysWeatherList.get(3).getIcon())));
        day_four_weather_discription.setText(onlyFiveDaysWeatherList.get(3).getDescription().toUpperCase());
        day_four_min_max_temp.setText(onlyFiveDaysWeatherList.get(3).getTemp_max()+"\u2103"+" / "+onlyFiveDaysWeatherList.get(3).getTemp_min().toUpperCase()+"\u2103");


        day_five_name.setText(Tools.dayNameFromTimeStamp(onlyFiveDaysWeatherList.get(4).getDt()));
        day_five_date.setText(Tools.dateFromTimeStamp(onlyFiveDaysWeatherList.get(4).getDt()));
        day_five_wheather_indicator_icon.setImageDrawable(getResources().getDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(),onlyFiveDaysWeatherList.get(4).getIcon())));
        day_five_weather_discription.setText(onlyFiveDaysWeatherList.get(4).getDescription().toUpperCase());
        day_five_min_max_temp.setText(onlyFiveDaysWeatherList.get(4).getTemp_max()+"\u2103"+" / "+onlyFiveDaysWeatherList.get(4).getTemp_min().toUpperCase()+"\u2103");

        //day_three_wheather_indicator_icon.setImageDrawable(Tools.convertDescriptionToImageWeather(getActivity().getApplicationContext(),fiveDaysWeatherList.get(2).getDescription()));
    }
}
