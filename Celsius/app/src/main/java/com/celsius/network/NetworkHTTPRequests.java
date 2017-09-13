package com.celsius.network;

import android.util.Log;

/**
 * Created by dennisshar on 26/08/2017.
 */

public class NetworkHTTPRequests {

    public static String API_KEY = "aa2df23d347d91a01f286584e35f2b7e";
    public static String SERVER_DOMAIN = "http://api.openweathermap.org/data/2.5/";
    public static String ACTION_WEATHER = "weather";
    public static String ACTION_5_DAY_FORCAST = "forecast";
    public static String ACTION_16_DAY_FORCAST = "forecast/daily";

    private static NetworkHTTPConnection networkHTTPConnection;

    public NetworkHTTPRequests() {
        networkHTTPConnection = new NetworkHTTPConnection();
    }

    private static String urlBuilder (String serverDomain,String apiAction, String cityName,String days,String apiKey,String tempUnits){
        if (days==null)
            return serverDomain+apiAction+"?"+"q="+cityName+"&APPID="+apiKey+"&units="+tempUnits;
        else
            return serverDomain+apiAction+"?"+"q="+cityName+"&cnt="+days+"&APPID="+apiKey+"&units="+tempUnits;

    }


    public static String currentWeatherData(String cityName,String requestType,String tempUnits){
        //Log.e("ServiceTest","NetworkHTTPRequests currentWeatherData");
        String url =  urlBuilder(SERVER_DOMAIN,ACTION_WEATHER,cityName,null,API_KEY,tempUnits);
        Log.e("ServiceTest","NetworkHTTPRequests currentWeatherData - >"+url);
        return networkHTTPConnection.getHttp(url,requestType);
    }

    public static String fiveDayWeatherForecast(String cityName,String requestType,String tempUnits){
        //Log.e("ServiceTest","NetworkHTTPRequests fiveDayWeatherForecast");
        String url =  urlBuilder(SERVER_DOMAIN,ACTION_5_DAY_FORCAST,cityName,null,API_KEY,tempUnits);
        Log.e("ServiceTest","NetworkHTTPRequests currentWeatherData - >"+url);
        return networkHTTPConnection.getHttp(url,requestType);
    }

    public static String sixTeenDayWeatherForecast(String cityName,String requestType,String tempUnits){
        //Log.e("ServiceTest","NetworkHTTPRequests sixTeenDayWeatherForecast");
        String url =  urlBuilder(SERVER_DOMAIN,ACTION_16_DAY_FORCAST,cityName,"16",API_KEY,tempUnits);
        Log.e("ServiceTest","NetworkHTTPRequests currentWeatherData - >"+url);
        return networkHTTPConnection.getHttp(url,requestType);
    }
}
