package com.celsius.responce.objects;

/**
 * Created by dennisshar on 28/08/2017.
 */

public class CurrentWeather {

    CoordObj coord;
    CurrentWeatherObj currentWeatherObj;
    BaseObj base;
    MainObj main;
    VisibilityObj visibility;
    WindObj wind;
    CloudsObj clouds;
    DtObj dt;
    SysObj sys;
    IdObj id;
    NameObj name;

    public CurrentWeather(){

    }

    public CurrentWeather(CoordObj coord, CurrentWeatherObj currentWeatherObj, BaseObj base, MainObj main, VisibilityObj visibility, WindObj wind, CloudsObj clouds, DtObj dt, SysObj sys, IdObj id, NameObj name) {
        this.coord = coord;
        this.currentWeatherObj = currentWeatherObj;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
    }


    public CoordObj getCoord() {
        return coord;
    }

    public void setCoord(CoordObj coord) {
        this.coord = coord;
    }

    public CurrentWeatherObj getCurrentWeatherObj() {
        return currentWeatherObj;
    }

    public void setCurrentWeatherObj(CurrentWeatherObj currentWeatherObj) {
        this.currentWeatherObj = currentWeatherObj;
    }

    public BaseObj getBase() {
        return base;
    }

    public void setBase(BaseObj base) {
        this.base = base;
    }

    public MainObj getMain() {
        return main;
    }

    public void setMain(MainObj main) {
        this.main = main;
    }

    public VisibilityObj getVisibility() {
        return visibility;
    }

    public void setVisibility(VisibilityObj visibility) {
        this.visibility = visibility;
    }

    public WindObj getWind() {
        return wind;
    }

    public void setWind(WindObj wind) {
        this.wind = wind;
    }

    public CloudsObj getClouds() {
        return clouds;
    }

    public void setClouds(CloudsObj clouds) {
        this.clouds = clouds;
    }

    public DtObj getDt() {
        return dt;
    }

    public void setDt(DtObj dt) {
        this.dt = dt;
    }

    public SysObj getSys() {
        return sys;
    }

    public void setSys(SysObj sys) {
        this.sys = sys;
    }

    public IdObj getId() {
        return id;
    }

    public void setId(IdObj id) {
        this.id = id;
    }

    public NameObj getName() {
        return name;
    }

    public void setName(NameObj name) {
        this.name = name;
    }

}




