package com.celsius.responce.parser;

import android.util.Log;

import com.celsius.responce.objects.BaseObj;
import com.celsius.responce.objects.CloudsObj;
import com.celsius.responce.objects.CoordObj;
import com.celsius.responce.objects.CurrentWeather;
import com.celsius.responce.objects.DtObj;
import com.celsius.responce.objects.FiveDaysWeather;
import com.celsius.responce.objects.FiveDaysWeatherItemObj;
import com.celsius.responce.objects.IdObj;
import com.celsius.responce.objects.MainObj;
import com.celsius.responce.objects.NameObj;
import com.celsius.responce.objects.SixTeenDaysWeather;
import com.celsius.responce.objects.SixTeenDaysWeatherItemObj;
import com.celsius.responce.objects.SysObj;
import com.celsius.responce.objects.TempObj;
import com.celsius.responce.objects.VisibilityObj;
import com.celsius.responce.objects.CurrentWeatherObj;
import com.celsius.responce.objects.CurrentWeatherItemObj;
import com.celsius.responce.objects.WindObj;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.celsius.responce.parser.JSONDictionary.ID;

/**
 * Created by dennisshar on 27/08/2017.
 */

public class JSONParser {



    public JSONParser() {
    }




    public CurrentWeather currentWeatherGenerator(String responce){
        try {


            JSONObject reader = new JSONObject(responce);

            JSONObject coordObject  = reader.getJSONObject(JSONDictionary.COORD);
            CoordObj coord = new CoordObj();
            coord.setLat(coordObject.optInt(JSONDictionary.LON,0));
            coord.setLat(coordObject.optInt(JSONDictionary.LAT,0));

            CurrentWeatherItemObj currentWeatherItemObj = null;
            JSONArray weatherObject  = reader.getJSONArray(JSONDictionary.WEATHER);
            for (int i = 0; i < weatherObject.length(); i++) {
                JSONObject item = weatherObject.getJSONObject(i);
                currentWeatherItemObj = new CurrentWeatherItemObj();
                currentWeatherItemObj.setId(item.optInt(ID,0));
                currentWeatherItemObj.setMain(item.optString(JSONDictionary.MAIN,null));
                currentWeatherItemObj.setDescription(item.optString(JSONDictionary.DESCRIPTION,null));
                currentWeatherItemObj.setIcon(item.optString(JSONDictionary.ICON,null));
            }


            ArrayList<CurrentWeatherItemObj> currentWeatherItemObjList = new ArrayList<>();
            currentWeatherItemObjList.add(currentWeatherItemObj);
            CurrentWeatherObj currentWeatherObj = new CurrentWeatherObj();
            currentWeatherObj.setCurrentWeatherItemObj(currentWeatherItemObjList);

            BaseObj base = new BaseObj();
            base.setBase(reader.getString(JSONDictionary.BASE));

            JSONObject mainsonObject  = reader.getJSONObject(JSONDictionary.MAIN);
            MainObj main = new MainObj();
            main.setTemp(mainsonObject.optDouble(JSONDictionary.TEMP));
            main.setPressure(mainsonObject.optDouble(JSONDictionary.PRESURE,0));
            main.setHumidity(mainsonObject.optDouble(JSONDictionary.HUMIDITY,0));
            main.setTemp_max(mainsonObject.optDouble(JSONDictionary.TEMP_MAX,0));
            main.setTemp_min(mainsonObject.optDouble(JSONDictionary.TEMP_MIN,0));

            VisibilityObj visibility = new VisibilityObj();
            visibility.setVisibility(reader.optInt(JSONDictionary.VISIBILITY,0));

            JSONObject windObject = reader.getJSONObject(JSONDictionary.WIND);
            WindObj wind = new WindObj();
            wind.setSpeed(windObject.optInt(JSONDictionary.SPEED,0));
            wind.setSpeed(windObject.optInt(JSONDictionary.DEG,0));

            JSONObject cloudsObject  = reader.getJSONObject(JSONDictionary.CLOUDS);
            CloudsObj clouds = new CloudsObj();
            clouds.setAll(cloudsObject.optInt(JSONDictionary.ALL,0));

            DtObj dt = new DtObj();
            dt.setDt(reader.getInt(JSONDictionary.DT));

            JSONObject sysObject  = reader.getJSONObject(JSONDictionary.SYS);
            SysObj sys = new SysObj();
            sys.setType(sysObject.optInt(JSONDictionary.TYPE,0));
            sys.setId(sysObject.optInt(ID,0));
            sys.setMessage(sysObject.optInt(JSONDictionary.MESSAGE,0));
            sys.setCountry(sysObject.optString(JSONDictionary.COUNTRY,null));
            sys.setSunrise(sysObject.optInt(JSONDictionary.SUNRISE,0));
            sys.setSunset(sysObject.optInt(JSONDictionary.SUNSET,0));


            IdObj id = new IdObj();
            id.setId(reader.optInt(JSONDictionary.DT,0));


            NameObj name = new NameObj();
            name.setName(reader.optString(JSONDictionary.NAME,null));

            CurrentWeather currentWeather = new CurrentWeather(coord, currentWeatherObj, base, main, visibility, wind, clouds, dt, sys, id, name);


            return currentWeather;

        } catch (JSONException e) {
            e.printStackTrace();
            return  null;
        }
    }


    public FiveDaysWeather fiveDaysWeatherGenerator(String responce){
        try {

            FiveDaysWeather weatherItem = new FiveDaysWeather();
            ArrayList<FiveDaysWeatherItemObj> fiveDaysWeatherList = new ArrayList<>();

            JSONObject reader = new JSONObject(responce);

            JSONArray weatherObject  = reader.getJSONArray(JSONDictionary.LIST);
            for (int i = 0; i < weatherObject.length(); i++) {
                JSONObject item = weatherObject.getJSONObject(i);


                DtObj dt = new DtObj();
                dt.setDt(item.optInt(JSONDictionary.DT));

                JSONObject mainsonObject  = item.getJSONObject(JSONDictionary.MAIN);
                MainObj main = new MainObj();
                main.setTemp(mainsonObject.optInt(JSONDictionary.TEMP,0));
                main.setPressure(mainsonObject.optDouble(JSONDictionary.PRESURE,0));
                main.setHumidity(mainsonObject.optDouble(JSONDictionary.HUMIDITY,0));
                main.setTemp_max(mainsonObject.optDouble(JSONDictionary.TEMP_MAX,0));
                main.setTemp_min(mainsonObject.optDouble(JSONDictionary.TEMP_MIN,0));
                main.setSea_level(mainsonObject.optDouble(JSONDictionary.SEA_LEVEL));
                main.setGrnd_level(mainsonObject.optDouble(JSONDictionary.GRAND_LEVEL,0));
                main.setTemp_kf(mainsonObject.optDouble(JSONDictionary.TEMP_KF,0));

                CurrentWeatherItemObj currentWeatherItemObj = null;
                JSONArray mainwWatherObject  = item.getJSONArray(JSONDictionary.WEATHER);
                for (int j = 0; j < mainwWatherObject.length(); j++) {
                    JSONObject mainWeatherItem = mainwWatherObject.getJSONObject(j);
                    currentWeatherItemObj = new CurrentWeatherItemObj();
                    currentWeatherItemObj.setId(mainWeatherItem.optInt(ID,0));
                    currentWeatherItemObj.setMain(mainWeatherItem.optString(JSONDictionary.MAIN,null));
                    currentWeatherItemObj.setDescription(mainWeatherItem.optString(JSONDictionary.DESCRIPTION,null));
                    currentWeatherItemObj.setIcon(mainWeatherItem.optString(JSONDictionary.ICON,null));
                }


                ArrayList<CurrentWeatherItemObj> currentWeatherItemObjList = new ArrayList<>();
                currentWeatherItemObjList.add(currentWeatherItemObj);
                CurrentWeatherObj currentWeatherObj = new CurrentWeatherObj();
                currentWeatherObj.setCurrentWeatherItemObj(currentWeatherItemObjList);



                JSONObject cloudsObject  = item.getJSONObject(JSONDictionary.CLOUDS);
                CloudsObj clouds = new CloudsObj();
                clouds.setAll(cloudsObject.optInt(JSONDictionary.ALL,0));


                JSONObject windObject = item.getJSONObject(JSONDictionary.WIND);
                WindObj wind = new WindObj();
                wind.setSpeed(windObject.optInt(JSONDictionary.SPEED,0));
                wind.setSpeed(windObject.optInt(JSONDictionary.DEG,0));


                FiveDaysWeatherItemObj fiveDaysWeatherItemObj = new FiveDaysWeatherItemObj();
                fiveDaysWeatherItemObj.setDt(dt);
                fiveDaysWeatherItemObj.setMain(main);
                fiveDaysWeatherItemObj.setWeather(currentWeatherItemObj);
                fiveDaysWeatherItemObj.setClouds(clouds);
                fiveDaysWeatherItemObj.setWind(wind);

                fiveDaysWeatherList.add(fiveDaysWeatherItemObj);

            }


            weatherItem.setFiveDaysWeather(fiveDaysWeatherList);



            return weatherItem;

        } catch (JSONException e) {
            e.printStackTrace();
            return  null;
        }
    }


    public SixTeenDaysWeather sixTeenDaysWeatherGenerator(String responce){
        try {

            JSONObject reader = new JSONObject(responce);


            SixTeenDaysWeather weatherItem = new SixTeenDaysWeather();
            ArrayList<SixTeenDaysWeatherItemObj> sixTeenDaysWeatherList = new ArrayList<>();


            JSONArray weatherObject  = reader.getJSONArray(JSONDictionary.LIST);
            for (int i = 0; i < weatherObject.length(); i++) {
                JSONObject item = weatherObject.getJSONObject(i);

                DtObj dt = new DtObj();
                dt.setDt(item.optInt(JSONDictionary.DT,0));


                JSONObject tempObject  = item.getJSONObject(JSONDictionary.TEMP);
                TempObj temp = new TempObj();
                temp.setDay(tempObject.optDouble(JSONDictionary.DAY,0));
                temp.setMin(tempObject.optDouble(JSONDictionary.MIN,0));
                temp.setMax(tempObject.optDouble(JSONDictionary.MAX,0));
                temp.setNight(tempObject.optDouble(JSONDictionary.NIGHT,0));
                temp.setEve(tempObject.optDouble(JSONDictionary.EVE,0));
                temp.setMorn(tempObject.optDouble(JSONDictionary.MORN,0));



                CurrentWeatherItemObj currentWeatherItemObj = null;
                JSONArray mainwWatherObject  = item.getJSONArray(JSONDictionary.WEATHER);
                for (int j = 0; j < mainwWatherObject.length(); j++) {
                    JSONObject mainWeatherItem = mainwWatherObject.getJSONObject(j);
                    currentWeatherItemObj = new CurrentWeatherItemObj();
                    currentWeatherItemObj.setId(mainWeatherItem.optInt(ID,0));
                    currentWeatherItemObj.setMain(mainWeatherItem.optString(JSONDictionary.MAIN,null));
                    currentWeatherItemObj.setDescription(mainWeatherItem.optString(JSONDictionary.DESCRIPTION,null));
                    currentWeatherItemObj.setIcon(mainWeatherItem.optString(JSONDictionary.ICON,null));
                }

                ArrayList<CurrentWeatherItemObj> currentWeatherItemObjList = new ArrayList<>();
                currentWeatherItemObjList.add(currentWeatherItemObj);
                CurrentWeatherObj currentWeatherObj = new CurrentWeatherObj();
                currentWeatherObj.setCurrentWeatherItemObj(currentWeatherItemObjList);

                SixTeenDaysWeatherItemObj sixTeenDaysWeatherItemObj = new SixTeenDaysWeatherItemObj();
                sixTeenDaysWeatherItemObj.setDt(dt);
                sixTeenDaysWeatherItemObj.setTemp(temp);
                sixTeenDaysWeatherItemObj.setWeather(currentWeatherItemObj);

                sixTeenDaysWeatherList.add(sixTeenDaysWeatherItemObj);

            }

            weatherItem.setSixTeenDaysWeather(sixTeenDaysWeatherList);



            return weatherItem;

        } catch (JSONException e) {
            e.printStackTrace();
            return  null;
        }
    }

}
