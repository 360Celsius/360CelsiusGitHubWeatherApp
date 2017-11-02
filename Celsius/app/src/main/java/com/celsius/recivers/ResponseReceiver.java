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
import com.celsius.services.WeatherPullService;
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
            //Log.e("ServiceTest","I am Here ResponseReceiver -> "+intent.getStringExtra(WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA) );
        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA)) {
            ft.replace(R.id.main_weather_info_placeholder, new MainInfoWeatherDataFragment());
        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA)){
            ft.replace(R.id.choosen_wheather_fragment_placeholder, new ThreeDaysWeatherDataFragment());
        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_FIVE_DAYS_WEATHER_DATA)){
            ft.replace(R.id.choosen_wheather_fragment_placeholder, new FIveDaysWeatherDataFragment());
        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_SIXTEEN_DAYS_WEATHER_DATA)){
            ft.replace(R.id.choosen_wheather_fragment_placeholder, new SixteenDaysWeatherDataFragment());
        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_EXTERNAL_IP_DATA)){
            //get external ip
            Intent msgIntentGetExternalIP = new Intent(context.getApplicationContext(), WeatherPullService.class);
            msgIntentGetExternalIP.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_LOCATION_BY_EXTERNAL_IP_DATA);
            context.startService(msgIntentGetExternalIP);
        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_LOCATION_BY_EXTERNAL_IP_DATA)){

            //get main info data
            Intent msgIntentMainData = new Intent(context.getApplicationContext(), WeatherPullService.class);
            msgIntentMainData.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA);
            context.startService(msgIntentMainData);

            //send current weather intent but send 5 days data in order to show 3 days.
            Intent msgIntentFiveDaysData = new Intent(context.getApplicationContext(), WeatherPullService.class);
            msgIntentFiveDaysData.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_THREE_DAYS_WEATHER_DATA);
            context.startService(msgIntentFiveDaysData);
        }

        ft.commit();


    }
}
