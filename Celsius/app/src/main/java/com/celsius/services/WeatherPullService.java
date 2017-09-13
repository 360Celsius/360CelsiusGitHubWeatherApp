package com.celsius.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.celsius.activities.base.BaseActivity;
import com.celsius.dbhelper.DatabaseHelper;
import com.celsius.network.NetworkHTTPRequests;
import com.celsius.responce.objects.CurrentWeather;
import com.celsius.responce.parser.JSONParser;

/**
 * Created by dennisshar on 25/08/2017.
 */

public class WeatherPullService extends IntentService {

    public static final String GET_WEATHER_DATA = "GET_WEATHER_DATA";
    private static NetworkHTTPRequests networkHTTPRequests;
    private JSONParser jsonParser;
    private DatabaseHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();
        networkHTTPRequests = new NetworkHTTPRequests();
        jsonParser = new JSONParser();
    }

    public WeatherPullService(String name) {
        super(name);
    }

    public WeatherPullService() {
        super("WeatherPullService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Log.e("ServiceTest","onHandleIntent");
        //Log.e("ServiceTest","onHandleIntent "+intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY));

        helper = BaseActivity.helper;//DatabaseHelper.getInstance(getApplicationContext());

        String responce = null;
        if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_THREE_DAYS_WEATHER_DATA)){
            //Log.e("ServiceTest","WeatherPullService onHandleIntent GET_CURRENT_WEATHER_DATA");
            responce = networkHTTPRequests.fiveDayWeatherForecast("Dublin",WeatherPullServicePutExtraKry.GET_FIVE_DAYS_WEATHER_DATA,"metric");

            helper.addFiveDaysWeather(jsonParser.fiveDaysWeatherGenerator(responce));

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_THREE_DAYS_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.THREE_DAY_WEATHER_FORCAST_DATA_RESPONCE, responce);
            sendBroadcast(broadcastIntent);

        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA)){
            //Log.e("ServiceTest","WeatherPullService onHandleIntent GET_CURRENT_WEATHER_DATA");
            responce = networkHTTPRequests.currentWeatherData("Dublin",WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA,"metric");

            helper.addCurrentWeather(jsonParser.currentWeatherGenerator(responce));

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.MAIN_INFO_WEATHER_DATA_RESPONCE, responce);
            sendBroadcast(broadcastIntent);

        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA)){
            //Log.e("ServiceTest","WeatherPullService onHandleIntent GET_CURRENT_WEATHER_DATA");
            responce = networkHTTPRequests.currentWeatherData("Dublin",WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA,"metric");

            helper.addCurrentWeather(jsonParser.currentWeatherGenerator(responce));

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.CURRENT_WEATHER_DATA_RESPONCE, responce);
            sendBroadcast(broadcastIntent);

        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_FIVE_DAYS_WEATHER_DATA)){
            //Log.e("ServiceTest","WeatherPullService onHandleIntent FIVE_DAY_WEATHER_FORCAST_DATA_RESPONCE");
            responce = networkHTTPRequests.fiveDayWeatherForecast("Dublin", WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA,"metric");


            helper.addFiveDaysWeather(jsonParser.fiveDaysWeatherGenerator(responce));
            //Log.e("ServiceTest","fiveDaysWeatherGenerator "+jsonParser.fiveDaysWeatherGenerator(responce).getFiveDaysWeather().get(0).getMain().getGrnd_level());


            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_FIVE_DAYS_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.FIVE_DAY_WEATHER_FORCAST_DATA_RESPONCE, responce);
            sendBroadcast(broadcastIntent);

        }else if(intent.getStringExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY).equalsIgnoreCase(WeatherPullServicePutExtraKry.GET_SIXTEEN_DAYS_WEATHER_DATA)){
            //Log.e("ServiceTest","WeatherPullService onHandleIntent SIXTEEN_DAY_WEATHER_FORCAST_DATA_RESPONCE");
            responce = networkHTTPRequests.sixTeenDayWeatherForecast("Dublin",WeatherPullServicePutExtraKry.GET_SIXTEEN_DAYS_WEATHER_DATA,"metric");


            helper.addSixteenDaysWeather(jsonParser.sixTeenDaysWeatherGenerator(responce));
            //Log.e("ServiceTest","sixTeenDaysWeatherGenerator "+jsonParser.sixTeenDaysWeatherGenerator(responce).getSixTeenDaysWeather().get(0).getDt().getDt());


            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(GET_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_SIXTEEN_DAYS_WEATHER_DATA);
            broadcastIntent.putExtra(WeatherPullServicePutExtraKry.SIXTEEN_DAY_WEATHER_FORCAST_DATA_RESPONCE, responce);
            sendBroadcast(broadcastIntent);
        }
    }
}
