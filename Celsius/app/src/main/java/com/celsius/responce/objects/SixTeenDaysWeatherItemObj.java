package com.celsius.responce.objects;

/**
 * Created by dennisshar on 31/08/2017.
 */

public class SixTeenDaysWeatherItemObj {

    DtObj dt;
    TempObj temp;

    public CurrentWeatherItemObj getWeather() {
        return weather;
    }

    public void setWeather(CurrentWeatherItemObj weather) {
        this.weather = weather;
    }

    CurrentWeatherItemObj weather;

    public SixTeenDaysWeatherItemObj() {
    }

    public DtObj getDt() {
        return dt;
    }

    public void setDt(DtObj dt) {
        this.dt = dt;
    }

    public TempObj getTemp() {
        return temp;
    }

    public void setTemp(TempObj temp) {
        this.temp = temp;
    }
}
