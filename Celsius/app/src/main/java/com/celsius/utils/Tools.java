package com.celsius.utils;

import android.content.Context;
import android.util.Log;

import com.celsius.dbhelper.FiveDaysWeatherQueryResponce;
import com.celsius.dbhelper.SixTeenDaysWeatherQueryResponce;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by dennisshar on 18/09/2017.
 */

public class Tools {

    public static int convertDescriptionToImageWeather(Context context, String icon){

        int imageResource = 0;
        icon = icon.substring(0,3);
        if(icon.equalsIgnoreCase("01d")||icon.equalsIgnoreCase("01n")){
            imageResource = context.getResources().getIdentifier("clear_sky", "drawable", context.getPackageName());
        }else if (icon.equalsIgnoreCase("02d")||icon.equalsIgnoreCase("02n")){
            imageResource = context.getResources().getIdentifier("few_clouds", "drawable", context.getPackageName());
        }else if (icon.equalsIgnoreCase("03d")||icon.equalsIgnoreCase("03n")){
            imageResource = context.getResources().getIdentifier("scattered_clouds", "drawable", context.getPackageName());
        }else if (icon.equalsIgnoreCase("04d")||icon.equalsIgnoreCase("04n")){
            imageResource = context.getResources().getIdentifier("broken_clouds", "drawable", context.getPackageName());
        }else if (icon.equalsIgnoreCase("09d")||icon.equalsIgnoreCase("09n")){
            imageResource = context.getResources().getIdentifier("shower_rain", "drawable", context.getPackageName());
        }else if (icon.equalsIgnoreCase("10d")||icon.equalsIgnoreCase("10n")){
            imageResource = context.getResources().getIdentifier("rain", "drawable", context.getPackageName());
        }else if (icon.equalsIgnoreCase("11d")||icon.equalsIgnoreCase("11n")){
            imageResource = context.getResources().getIdentifier("thunderstorm", "drawable", context.getPackageName());
        }else if (icon.equalsIgnoreCase("13d")||icon.equalsIgnoreCase("13n")){
            imageResource = context.getResources().getIdentifier("snow", "drawable", context.getPackageName());
        }else if (icon.equalsIgnoreCase("50d")||icon.equalsIgnoreCase("50n")){
            imageResource = context.getResources().getIdentifier("mist", "drawable", context.getPackageName());
        }
        return imageResource;
    }

    public static String dayNameFromTimeStamp(String timeStamp){

        //SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.LONG, Locale.US);//new Locale("en", Locale.getDefault().getCountry()));
        String resultPattern = "EEEE";//sdf.toPattern();

        DateFormat dateFormat = new SimpleDateFormat(resultPattern, new Locale("en", Locale.getDefault().getCountry()));
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+07:00"));
        String date = dateFormat.format(new Date(Integer.parseInt(timeStamp)*1000L));

        return date;
    }

    public static String dateFromTimeStamp(String timeStamp){

        //SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.LONG, Locale.US);//new Locale("en", Locale.getDefault().getCountry()));
        String resultPattern = "yyyy-MM-dd";//sdf.toPattern();

        DateFormat dateFormat = new SimpleDateFormat(resultPattern, new Locale("en", Locale.getDefault().getCountry()));
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+07:00"));
        String date = dateFormat.format(new Date(Integer.parseInt(timeStamp)*1000L)).toString();

        //getNextDay(timeStamp);

        return date;
    }


    public static String getCurrentData(){

        //SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.LONG, Locale.US);//new Locale("en", Locale.getDefault().getCountry()));
        String resultPattern = "MM/dd/yyyy, EEEE";//sdf.toPattern();

        DateFormat dateFormat = new SimpleDateFormat(resultPattern, new Locale("en", Locale.getDefault().getCountry()));
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+07:00"));
        String date = dateFormat.format(new Date(System.currentTimeMillis())).toString();

        //getNextDay(timeStamp);

        return date;
    }

    public static ArrayList<FiveDaysWeatherQueryResponce> fiveDaysfilteredList( ArrayList<FiveDaysWeatherQueryResponce> list, int daysLimit){

        String resultPattern = "yy/MM/dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(resultPattern, new Locale("en", Locale.getDefault().getCountry()));
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+07:00"));
        //String date = dateFormat.format(new Date(Integer.parseInt(timeStamp)*1000L)).toString();

        ArrayList<FiveDaysWeatherQueryResponce> newList = new ArrayList<>();

        for (int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++) {
                Date d1 = new Date(Integer.parseInt(list.get(i).getDt()) * 1000L);
                Date d2 = new Date(Integer.parseInt(list.get(j).getDt()) * 1000L);
                long diff = d2.getTime() - d1.getTime();
                long days = TimeUnit.MILLISECONDS.toDays(diff);
                if(days == 1){
                    newList.add(list.get(i));
                    i = j;
                    break;
                }

                //Log.e("difftest",String.valueOf(days));
            }
            if(newList.size()==daysLimit){
                break;
            }
        }

        if(newList.size()<daysLimit){
            newList.add(list.get(list.size()-12));
        }

        return newList;
    }

}
