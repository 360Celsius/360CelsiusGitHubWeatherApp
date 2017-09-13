package com.celsius.responce.objects;

import java.util.ArrayList;

/**
 * Created by dennisshar on 30/08/2017.
 */

public class FiveDaysWeather {

    ArrayList<FiveDaysWeatherItemObj> fiveDaysWeather;

    public FiveDaysWeather() {

    }

    public ArrayList<FiveDaysWeatherItemObj> getFiveDaysWeather() {
        return fiveDaysWeather;
    }

    public void setFiveDaysWeather(ArrayList<FiveDaysWeatherItemObj> fiveDaysWeather) {
        this.fiveDaysWeather = fiveDaysWeather;
    }
}
