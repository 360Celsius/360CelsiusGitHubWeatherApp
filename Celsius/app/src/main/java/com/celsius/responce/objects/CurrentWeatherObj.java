package com.celsius.responce.objects;

import java.util.ArrayList;

/**
 * Created by dennisshar on 28/08/2017.
 */

public class CurrentWeatherObj {
    ArrayList<CurrentWeatherItemObj> currentWeatherItemObj;

    public CurrentWeatherObj() {
    }

    public ArrayList<CurrentWeatherItemObj> getCurrentWeatherItemObj() {
        return currentWeatherItemObj;
    }

    public void setCurrentWeatherItemObj(ArrayList<CurrentWeatherItemObj> currentWeatherItemObj) {
        this.currentWeatherItemObj = currentWeatherItemObj;
    }
}
