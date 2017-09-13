package com.celsius.responce.objects;

/**
 * Created by dennisshar on 30/08/2017.
 */

public class FiveDaysWeatherItemObj {

    DtObj dt;
    MainObj main;
    CurrentWeatherItemObj weather;
    CloudsObj clouds;
    WindObj wind;

    public FiveDaysWeatherItemObj() {
    }


    public DtObj getDt() {
        return dt;
    }

    public void setDt(DtObj dt) {
        this.dt = dt;
    }

    public MainObj getMain() {
        return main;
    }

    public void setMain(MainObj main) {
        this.main = main;
    }

    public CurrentWeatherItemObj getWeather() {
        return weather;
    }

    public void setWeather(CurrentWeatherItemObj weather) {
        this.weather = weather;
    }

    public CloudsObj getClouds() {
        return clouds;
    }

    public void setClouds(CloudsObj clouds) {
        this.clouds = clouds;
    }

    public WindObj getWind() {
        return wind;
    }

    public void setWind(WindObj wind) {
        this.wind = wind;
    }
}
