package com.celsius.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.celsius.responce.objects.CurrentLocationObj;
import com.celsius.responce.objects.CurrentWeather;
import com.celsius.responce.objects.ExternalIPObj;
import com.celsius.responce.objects.FiveDaysWeather;
import com.celsius.responce.objects.SixTeenDaysWeather;

import java.util.ArrayList;

/**
 * Created by dennisshar on 01/09/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_TABLE_CURRENT_WEATHER_TABLE_NAME_KEY = "current_weather";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAN_KEY = "lan";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAT_KEY = "lat";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ID_KEY = "id";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_MAIN_KEY = "main";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_DESCRIPTION_KEY = "description";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ICON_KEY = "icon";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMP_KEY = "temp";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_PRESURE_KEY = "presure";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_HUMIDITY_KEY = "humidity";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMIN_KEY = "temp_min";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMAX_KEY = "temp_max";
    public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUNM_DT_KEY = "dt";

    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_TABLE_NAME_KEY = "fivedays_weather";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_DT_KEY = "dt";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_TEMP_KEY = "temp";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMIN_KEY = "temp_min";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMAX_KEY = "temp_max";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_PRESURE_KEY = "pressure";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_SEALEVEL_KEY = "sea_level";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_GRNDLEVEL_KEY = "grnd_level";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_HUMIDITY_KEY = "humidity";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_DESCRIPTION_KEY = "description";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_ICON_KEY = "icon";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_SPEED_KEY = "speed";
    public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_DEG_KEY = "deg";

    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_TABLE_NAME_KEY = "sixteendays_weather";
    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DT_KEY = "dt";
    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DAY_KEY = "day";
    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MIN_KEY = "min";
    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MAX_KEY = "max";
    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_NIGHT_KEY = "night";
    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_EVE_KEY = "eve";
    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_ICON_KEY = "icon";
    public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MORN_KEY = "morn";


    public static final String DATABASE_TABLE_EXTERNAL_IP_TABLE_NAME_KEY = "external_ip";
    public static final String DATABASE_TABLE_EXTERNAL_IP_COLUMN_KEY = "id";
    public static final String DATABASE_TABLE_EXTERNAL_HOSTNAME_COLUMN_KEY = "hostname";
    public static final String DATABASE_TABLE_EXTERNAL_CITY_COLUMN_KEY = "city";
    public static final String DATABASE_TABLE_EXTERNAL_REGION_COLUMN_KEY = "region";
    public static final String DATABASE_TABLE_EXTERNAL_COUNTRY_COLUMN_KEY = "country";
    public static final String DATABASE_TABLE_EXTERNAL_LOC_COLUMN_KEY = "loc";
    public static final String DATABASE_TABLE_EXTERNAL_ORG_COLUMN_KEY = "org";


    public static final String DATABASE_TABLE_CURRENT_LOCATION_TABLE_NAME_KEY = "current_location";
    public static final String DATABASE_TABLE_CURRENT_AS_COLUMN_KEY = "as";
    public static final String DATABASE_TABLE_CURRENT_CITY_COLUMN_KEY = "city";
    public static final String DATABASE_TABLE_CURRENT_COUNTRY_COLUMN_KEY = "country";
    public static final String DATABASE_TABLE_CURRENT_COUNTRYCODE_COLUMN_KEY = "countryCode";
    public static final String DATABASE_TABLE_CURRENT_ISP_COLUMN_KEY = "isp";
    public static final String DATABASE_TABLE_CURRENT_LAT_COLUMN_KEY = "lat";
    public static final String DATABASE_TABLE_CURRENT_LON_COLUMN_KEY = "lon";
    public static final String DATABASE_TABLE_CURRENT_ORG_COLUMN_KEY = "org";
    public static final String DATABASE_TABLE_CURRENT_QUERY_COLUMN_KEY = "query";
    public static final String DATABASE_TABLE_CURRENT_REGION_COLUMN_KEY = "region";
    public static final String DATABASE_TABLE_CURRENT_REGIONNAME_COLUMN_KEY = "regionName";
    public static final String DATABASE_TABLE_CURRENT_STATUS_COLUMN_KEY = "status";
    public static final String DATABASE_TABLE_CURRENT_TIMEZONE_COLUMN_KEY = "timezone";
    public static final String DATABASE_TABLE_CURRENT_ZIP_COLUMN_KEY = "zip";

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "CelsiusWeather.db";
    private static DatabaseHelper sInstance;


    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("versioncode","DatabaseHelper onCreate ");
        db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_CURRENT_WEATHER);
        db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_FIVEDAYS_WEATHER);
        db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_SIXTEENDAYS_WEATHER);
        db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_EXTERNAL_IP);
        db.execSQL(DataBaseHelperContract.SQL_CREATE_CURRENT_LOCATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("versioncode","DatabaseHelper onUpgrade oldVersion "+String.valueOf(oldVersion));
        Log.e("versioncode","DatabaseHelper onUpgrade newVersion "+String.valueOf(newVersion));
        if (oldVersion != newVersion) {
            db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_CURRENT_WEATHER);
            db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_FIVEDAYS_WEATHER);
            db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_SIXTEENDAYS_WEATHER);
            db.execSQL(DataBaseHelperContract.SQL_CREATE_ENTRIES_EXTERNAL_IP);
            db.execSQL(DataBaseHelperContract.SQL_CREATE_CURRENT_LOCATION);
            onCreate(db);
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void addExternalIPData(ExternalIPObj externalIPObj){
        deleteExternalIPTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();

        try{
            ContentValues values = new ContentValues();
            values.put(DATABASE_TABLE_EXTERNAL_IP_COLUMN_KEY, externalIPObj.getIp());
            values.put(DATABASE_TABLE_EXTERNAL_HOSTNAME_COLUMN_KEY, externalIPObj.getHostname());
            values.put(DATABASE_TABLE_EXTERNAL_CITY_COLUMN_KEY, externalIPObj.getCity());
            values.put(DATABASE_TABLE_EXTERNAL_REGION_COLUMN_KEY, externalIPObj.getRegion());
            values.put(DATABASE_TABLE_EXTERNAL_COUNTRY_COLUMN_KEY, externalIPObj.getCountry());
            values.put(DATABASE_TABLE_EXTERNAL_LOC_COLUMN_KEY, externalIPObj.getLoc());
            values.put(DATABASE_TABLE_EXTERNAL_ORG_COLUMN_KEY, externalIPObj.getOrg());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(DATABASE_TABLE_EXTERNAL_IP_TABLE_NAME_KEY, null, values);
            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

    }


    public void addCurrentLocationData(CurrentLocationObj currentLocationObj){
        deleteCurrentLocationTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();

        try{
            ContentValues values = new ContentValues();
            //values.put(DATABASE_TABLE_CURRENT_AS_COLUMN_KEY, currentLocationObj.getAs());
            values.put(DATABASE_TABLE_CURRENT_CITY_COLUMN_KEY, currentLocationObj.getCity());
            values.put(DATABASE_TABLE_CURRENT_COUNTRY_COLUMN_KEY, currentLocationObj.getCountry());
            values.put(DATABASE_TABLE_CURRENT_COUNTRYCODE_COLUMN_KEY, currentLocationObj.getCountryCode());
            values.put(DATABASE_TABLE_CURRENT_ISP_COLUMN_KEY, currentLocationObj.getIsp());
            values.put(DATABASE_TABLE_CURRENT_LAT_COLUMN_KEY, currentLocationObj.getLat());
            values.put(DATABASE_TABLE_CURRENT_LON_COLUMN_KEY, currentLocationObj.getLan());
            values.put(DATABASE_TABLE_CURRENT_ORG_COLUMN_KEY, currentLocationObj.getOrg());
            values.put(DATABASE_TABLE_CURRENT_QUERY_COLUMN_KEY, currentLocationObj.getQuery());
            values.put(DATABASE_TABLE_CURRENT_REGION_COLUMN_KEY, currentLocationObj.getRegion());
            values.put(DATABASE_TABLE_CURRENT_REGIONNAME_COLUMN_KEY, currentLocationObj.getRegionName());
            values.put(DATABASE_TABLE_CURRENT_STATUS_COLUMN_KEY, currentLocationObj.getStatus());
            values.put(DATABASE_TABLE_CURRENT_TIMEZONE_COLUMN_KEY, currentLocationObj.getTimezone());
            values.put(DATABASE_TABLE_CURRENT_ZIP_COLUMN_KEY, currentLocationObj.getZip());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(DATABASE_TABLE_CURRENT_LOCATION_TABLE_NAME_KEY, null, values);
            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
    }


    public void addCurrentWeather(CurrentWeather currentWeather) {

        deleteCurrentWeatherTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAN_KEY, currentWeather.getCoord().getLon());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAT_KEY, currentWeather.getCoord().getLat());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ID_KEY, currentWeather.getCurrentWeatherObj().getCurrentWeatherItemObj().get(0).getId());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_MAIN_KEY, currentWeather.getCurrentWeatherObj().getCurrentWeatherItemObj().get(0).getMain());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_DESCRIPTION_KEY, currentWeather.getCurrentWeatherObj().getCurrentWeatherItemObj().get(0).getDescription());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ICON_KEY, currentWeather.getCurrentWeatherObj().getCurrentWeatherItemObj().get(0).getIcon());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMP_KEY, currentWeather.getMain().getTemp());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_PRESURE_KEY, currentWeather.getMain().getPressure());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_HUMIDITY_KEY, currentWeather.getMain().getHumidity());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMIN_KEY, currentWeather.getMain().getTemp_min());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMAX_KEY, currentWeather.getMain().getTemp_max());
            values.put(DATABASE_TABLE_CURRENT_WEATHER_COLUNM_DT_KEY, currentWeather.getDt().getDt());


            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(DATABASE_TABLE_CURRENT_WEATHER_TABLE_NAME_KEY, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {

        } finally {
            db.endTransaction();
        }
    }

    public void addFiveDaysWeather(FiveDaysWeather fiveDaysWeather) {

        deleteFiveDaysWeatherTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            for(int i=0;i<fiveDaysWeather.getFiveDaysWeather().size();i++){

                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_DT_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getDt().getDt());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_TEMP_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getMain().getTemp());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMIN_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getMain().getTemp_min());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMAX_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getMain().getTemp_max());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_PRESURE_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getMain().getPressure());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_SEALEVEL_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getMain().getSea_level());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_GRNDLEVEL_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getMain().getGrnd_level());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_HUMIDITY_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getMain().getHumidity());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_DESCRIPTION_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getWeather().getDescription());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_ICON_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getWeather().getIcon());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_SPEED_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getWind().getSpeed());
                values.put(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_DEG_KEY, fiveDaysWeather.getFiveDaysWeather().get(i).getWind().getDeg());

                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DATABASE_TABLE_FIVEDAYS_WEATHER_TABLE_NAME_KEY, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void addSixteenDaysWeather(SixTeenDaysWeather sixTeenWeather) {

        deleteSixteenWeatherTable();

        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            for(int i=0;i<sixTeenWeather.getSixTeenDaysWeather().size();i++){

                values.put(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DT_KEY, sixTeenWeather.getSixTeenDaysWeather().get(i).getDt().getDt());
                values.put(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DAY_KEY, sixTeenWeather.getSixTeenDaysWeather().get(i).getTemp().getDay());
                values.put(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MIN_KEY, sixTeenWeather.getSixTeenDaysWeather().get(i).getTemp().getMin());
                values.put(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MAX_KEY, sixTeenWeather.getSixTeenDaysWeather().get(i).getTemp().getMax());
                values.put(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_NIGHT_KEY, sixTeenWeather.getSixTeenDaysWeather().get(i).getTemp().getNight());
                values.put(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_EVE_KEY, sixTeenWeather.getSixTeenDaysWeather().get(i).getTemp().getEve());
                values.put(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MORN_KEY, sixTeenWeather.getSixTeenDaysWeather().get(i).getTemp().getMorn());
                values.put(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_ICON_KEY, sixTeenWeather.getSixTeenDaysWeather().get(i).getWeather().getIcon());


                // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
                db.insertOrThrow(DATABASE_TABLE_SIXTEENDAYS_WEATHER_TABLE_NAME_KEY, null, values);

            }
            db.setTransactionSuccessful();

        } catch (Exception e) {

        } finally {
            db.endTransaction();
        }
    }

    public void deleteExternalIPTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DATABASE_TABLE_EXTERNAL_IP_TABLE_NAME_KEY, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteCurrentLocationTable(){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DATABASE_TABLE_CURRENT_LOCATION_TABLE_NAME_KEY, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }


    public void deleteCurrentWeatherTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DATABASE_TABLE_CURRENT_WEATHER_TABLE_NAME_KEY, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteFiveDaysWeatherTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DATABASE_TABLE_FIVEDAYS_WEATHER_TABLE_NAME_KEY, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void deleteSixteenWeatherTable() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(DATABASE_TABLE_SIXTEENDAYS_WEATHER_TABLE_NAME_KEY, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public ArrayList<CurrentWeatherQueryResponce> getCurrentWeather(){

        String queryGetCurrentWEATHER = "SELECT  * FROM " + DATABASE_TABLE_CURRENT_WEATHER_TABLE_NAME_KEY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(queryGetCurrentWEATHER, null);

        ArrayList<CurrentWeatherQueryResponce> currentWeatherList = new ArrayList<>();

        try {

            if (cursor.moveToFirst()) {
                do {
                    CurrentWeatherQueryResponce currentWeatherItem = new CurrentWeatherQueryResponce();
                    currentWeatherItem.setLan(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAN_KEY)));
                    currentWeatherItem.setLat(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAT_KEY)));
                    currentWeatherItem.setId(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ID_KEY)));
                    currentWeatherItem.setMain(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_MAIN_KEY)));
                    currentWeatherItem.setDescription(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_DESCRIPTION_KEY)));
                    currentWeatherItem.setIcon(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ICON_KEY)));
                    currentWeatherItem.setTemp(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMP_KEY)));
                    currentWeatherItem.setHumidity(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_HUMIDITY_KEY)));
                    currentWeatherItem.setTemp_min(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMIN_KEY)));
                    currentWeatherItem.setTemp_max(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMAX_KEY)));
                    currentWeatherItem.setDt(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUNM_DT_KEY)));
                    currentWeatherItem.setPresure(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_WEATHER_COLUMN_PRESURE_KEY)));

                    currentWeatherList.add(currentWeatherItem);

                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        Log.e("interfacetest","DatabaseHelper getCurrentWeather");
        return currentWeatherList;
    }

    public ArrayList<FiveDaysWeatherQueryResponce> getFiveDaysWeather(){

        String queryGetFIveDaysWEATHER = "SELECT  * FROM " + DATABASE_TABLE_FIVEDAYS_WEATHER_TABLE_NAME_KEY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(queryGetFIveDaysWEATHER, null);

        ArrayList<FiveDaysWeatherQueryResponce> fiveDaysWeatherList = new ArrayList<>();

        try {
            if (cursor.moveToFirst()) {
                do {

                    FiveDaysWeatherQueryResponce fiveDaysWeatherItem = new FiveDaysWeatherQueryResponce();
                    fiveDaysWeatherItem.setDt(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_DT_KEY)));
                    fiveDaysWeatherItem.setTemp(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_TEMP_KEY)));
                    fiveDaysWeatherItem.setTemp_min(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMIN_KEY)));
                    fiveDaysWeatherItem.setTemp_max(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMAX_KEY)));
                    fiveDaysWeatherItem.setPressure(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_PRESURE_KEY)));
                    fiveDaysWeatherItem.setSea_level(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_SEALEVEL_KEY)));
                    fiveDaysWeatherItem.setGrnd_level(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_GRNDLEVEL_KEY)));
                    fiveDaysWeatherItem.setHumidity(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_HUMIDITY_KEY)));
                    fiveDaysWeatherItem.setIcon(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_ICON_KEY)));
                    fiveDaysWeatherItem.setSpeed(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_SPEED_KEY)));
                    fiveDaysWeatherItem.setDeg(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_DEG_KEY)));
                    fiveDaysWeatherItem.setDescription(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_DESCRIPTION_KEY)));
                    fiveDaysWeatherList.add(fiveDaysWeatherItem);



                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        Log.e("interfacetest","DatabaseHelper getFiveDaysWeather");
        return fiveDaysWeatherList;
    }

    public ArrayList<SixTeenDaysWeatherQueryResponce> getSixTeenDaysWeather(){

        String queryGetSixTeenDaysWEATHER = "SELECT  * FROM " + DATABASE_TABLE_SIXTEENDAYS_WEATHER_TABLE_NAME_KEY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(queryGetSixTeenDaysWEATHER, null);

        ArrayList<SixTeenDaysWeatherQueryResponce> sixTeenDaysWeatherList = new ArrayList<>();

        try {
            if (cursor.moveToFirst()) {
                do {

                    SixTeenDaysWeatherQueryResponce sixTeenDaysWeatherQueryResponce = new SixTeenDaysWeatherQueryResponce();
                    sixTeenDaysWeatherQueryResponce.setDt(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DT_KEY)));
                    sixTeenDaysWeatherQueryResponce.setDay(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DAY_KEY)));
                    sixTeenDaysWeatherQueryResponce.setMin(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MIN_KEY)));
                    sixTeenDaysWeatherQueryResponce.setMax(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MAX_KEY)));
                    sixTeenDaysWeatherQueryResponce.setNight(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_NIGHT_KEY)));
                    sixTeenDaysWeatherQueryResponce.setEve(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_EVE_KEY)));
                    sixTeenDaysWeatherQueryResponce.setMorn(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MORN_KEY)));
                    sixTeenDaysWeatherQueryResponce.setIcon(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_ICON_KEY)));
                    sixTeenDaysWeatherList.add(sixTeenDaysWeatherQueryResponce);

                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        Log.e("interfacetest","DatabaseHelper getSixTeenDaysWeather");
        return sixTeenDaysWeatherList;
    }

    public ExternalIPQueryResponce getExternalIPDATA(){
        String queryGetSixTeenDaysWEATHER = "SELECT  * FROM " + DATABASE_TABLE_EXTERNAL_IP_TABLE_NAME_KEY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(queryGetSixTeenDaysWEATHER, null);
        ExternalIPQueryResponce externalIPQueryResponce = new ExternalIPQueryResponce();

        try{
            if (cursor.moveToFirst()) {
                externalIPQueryResponce.setIp(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_EXTERNAL_IP_COLUMN_KEY)));
                externalIPQueryResponce.setHostname(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_EXTERNAL_HOSTNAME_COLUMN_KEY)));
                externalIPQueryResponce.setCity(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_EXTERNAL_CITY_COLUMN_KEY)));
                externalIPQueryResponce.setRegion(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_EXTERNAL_REGION_COLUMN_KEY)));
                externalIPQueryResponce.setCountry(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_EXTERNAL_COUNTRY_COLUMN_KEY)));
                externalIPQueryResponce.setLoc(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_EXTERNAL_LOC_COLUMN_KEY)));
                externalIPQueryResponce.setOrg(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_EXTERNAL_ORG_COLUMN_KEY)));

            }

        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return externalIPQueryResponce;
    }

    public CurrentLocationQueryResponce getCurrentLocationDATA(){
        String queryGetSixTeenDaysWEATHER = "SELECT  * FROM " + DATABASE_TABLE_CURRENT_LOCATION_TABLE_NAME_KEY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(queryGetSixTeenDaysWEATHER, null);
        CurrentLocationQueryResponce currentLocationQueryResponce = new CurrentLocationQueryResponce();

        try{
            if (cursor.moveToFirst()) {
               // currentLocationQueryResponce.setAs(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_AS_COLUMN_KEY)));
                currentLocationQueryResponce.setCity(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_CITY_COLUMN_KEY)));
                currentLocationQueryResponce.setCountry(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_COUNTRY_COLUMN_KEY)));
                currentLocationQueryResponce.setCountryCode(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_COUNTRYCODE_COLUMN_KEY)));
                currentLocationQueryResponce.setIsp(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_ISP_COLUMN_KEY)));
                currentLocationQueryResponce.setLat(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_LAT_COLUMN_KEY)));
                currentLocationQueryResponce.setLan(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_LON_COLUMN_KEY)));
                currentLocationQueryResponce.setOrg(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_ORG_COLUMN_KEY)));
                currentLocationQueryResponce.setQuery(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_QUERY_COLUMN_KEY)));
                currentLocationQueryResponce.setRegion(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_REGION_COLUMN_KEY)));
                currentLocationQueryResponce.setRegionName(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_REGIONNAME_COLUMN_KEY)));
                currentLocationQueryResponce.setStatus(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_STATUS_COLUMN_KEY)));
                currentLocationQueryResponce.setTimezone(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_TIMEZONE_COLUMN_KEY)));
                currentLocationQueryResponce.setZip(cursor.getString(cursor.getColumnIndex(DATABASE_TABLE_CURRENT_ZIP_COLUMN_KEY)));

            }

        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return currentLocationQueryResponce;
    }
}
