package com.celsius.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ahrenheit.celsius.activities.R;
import com.celsius.fragments.ThreeDaysWeatherDataFragment;
import com.celsius.fragments.FIveDaysWeatherDataFragment;
import com.celsius.fragments.MainInfoWeatherDataFragment;
import com.celsius.fragments.SixteenDaysWeatherDataFragment;
import com.celsius.services.WeatherPullServicePutExtraKry;

/**
 * Created by dennisshar on 26/08/2017.
 */

public class ResponseReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        FragmentTransaction ft =   ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();

        if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_THREE_DAYS_WEATHER_DATA)) {
            ft.replace(R.id.choosen_wheather_fragment_placeholder, new ThreeDaysWeatherDataFragment());
            ft.commit();
            //Log.e("ServiceTest","I am Here ResponseReceiver -> "+intent.getStringExtra(WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA) );
        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA)) {
            ft.replace(R.id.main_weather_info_placeholder, new MainInfoWeatherDataFragment());
            ft.commit();
            //Log.e("ServiceTest","I am Here ResponseReceiver -> "+intent.getStringExtra(WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA) );
        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA)){
            ft.replace(R.id.choosen_wheather_fragment_placeholder, new ThreeDaysWeatherDataFragment());
            ft.commit();
            //Log.e("ServiceTest","I am Here ResponseReceiver -> "+intent.getStringExtra(WeatherPullServicePutExtraKry.CURRENT_WEATHER_DATA_RESPONCE) );

        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_FIVE_DAYS_WEATHER_DATA)){
            ft.replace(R.id.choosen_wheather_fragment_placeholder, new FIveDaysWeatherDataFragment());
            ft.commit();
            //Log.e("ServiceTest","I am Here ResponseReceiver -> "+intent.getStringExtra(WeatherPullServicePutExtraKry.FIVE_DAY_WEATHER_FORCAST_DATA_RESPONCE) );

        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_SIXTEEN_DAYS_WEATHER_DATA)){
            ft.replace(R.id.choosen_wheather_fragment_placeholder, new SixteenDaysWeatherDataFragment());
            ft.commit();
            //Log.e("ServiceTest","I am Here ResponseReceiver -> "+intent.getStringExtra(WeatherPullServicePutExtraKry.SIXTEEN_DAY_WEATHER_FORCAST_DATA_RESPONCE) );
        }


    }
}
