package com.celsius.responce.objects;

import java.util.ArrayList;

/**
 * Created by dennisshar on 30/08/2017.
 */

public class SixTeenDaysWeather {

    ArrayList<SixTeenDaysWeatherItemObj> sixTeenDaysWeather;

    public SixTeenDaysWeather() {

    }

    public ArrayList<SixTeenDaysWeatherItemObj> getSixTeenDaysWeather() {
        return sixTeenDaysWeather;
    }

    public void setSixTeenDaysWeather(ArrayList<SixTeenDaysWeatherItemObj> fiveDaysWeather) {
        this.sixTeenDaysWeather = fiveDaysWeather;
    }
}
