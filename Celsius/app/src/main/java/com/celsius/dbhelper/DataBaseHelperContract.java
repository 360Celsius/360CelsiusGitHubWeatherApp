package com.celsius.dbhelper;

import android.provider.BaseColumns;

/**
 * Created by dennisshar on 01/09/2017.
 */

public class DataBaseHelperContract {



    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DataBaseHelperContract() {
    }

    /* Inner class that defines the table contents */
    private static class CURRENT_WEATHER implements BaseColumns {

        public static final String DATABASE_TABLE_CURRENT_WEATHER_TABLE_NAME = "current_weather";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAN = "lan";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAT = "lat";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ID = "id";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_MAIN = "main";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_DESCRIPTION = "description";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ICON = "icon";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMP = "temp";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_PRESURE = "presure";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_HUMIDITY = "humidity";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMIN = "temp_min";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMAX = "temp_max";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_WIND_SPEED = "speed";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUMN_WIND_DEG = "deg";
        public static final String DATABASE_TABLE_CURRENT_WEATHER_COLUNM_DT = "dt";

    }


    public static final String SQL_CREATE_ENTRIES_CURRENT_WEATHER =
                     "CREATE TABLE " + CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_TABLE_NAME + " (" +
                    CURRENT_WEATHER._ID + " INTEGER PRIMARY KEY," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAN + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_LAT + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ID + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_MAIN + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_DESCRIPTION + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_ICON + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMP + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_PRESURE + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_HUMIDITY + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMIN + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_TEMPMAX + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_WIND_SPEED + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUNM_DT + " TEXT," +
                    CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_COLUMN_WIND_DEG + " TEXT)";

    public static final String SQL_DELETE_ENTRIES_CURRENT_WEATHER =
            "DROP TABLE IF EXISTS " + CURRENT_WEATHER.DATABASE_TABLE_CURRENT_WEATHER_TABLE_NAME;




    /* Inner class that defines the table contents */
    private static class FIVEDAYS_WEATHER implements BaseColumns {
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_TABLE_NAME = "fivedays_weather";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_DT = "dt";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_TEMP = "temp";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMIN = "temp_min";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMAX = "temp_max";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_PRESURE = "pressure";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_SEALEVEL = "sea_level";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_GRNDLEVEL = "grnd_level";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_HUMIDITY = "humidity";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_DESCRIPTION = "description";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_ICON = "icon";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_SPEED = "speed";
        public static final String DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_DEG = "deg";
    }


    public static final String SQL_CREATE_ENTRIES_FIVEDAYS_WEATHER =
            "CREATE TABLE " + FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_TABLE_NAME + " (" +
                    FIVEDAYS_WEATHER._ID + " INTEGER PRIMARY KEY," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_DT + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_TEMP + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMIN + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_TEMPMAX + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_PRESURE + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUNM_SEALEVEL + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_GRNDLEVEL + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_HUMIDITY + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_DESCRIPTION + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_ICON + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_SPEED + " TEXT," +
                    FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_COLUMN_WIND_DEG + " TEXT)";

    public static final String SQL_DELETE_ENTRIES_FIVEDAYS_WEATHER =
            "DROP TABLE IF EXISTS " + FIVEDAYS_WEATHER.DATABASE_TABLE_FIVEDAYS_WEATHER_TABLE_NAME;



    /* Inner class that defines the table contents */
    private static class SIXTEENDAYS_WEATHER implements BaseColumns {
        public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_TABLE_NAME = "sixteendays_weather";
        public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DT = "dt";
        public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DAY = "day";
        public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MIN = "min";
        public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MAX = "max";
        public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_NIGHT = "night";
        public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_EVE = "eve";
        public static final String DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MORN = "morn";
    }


    public static final String SQL_CREATE_ENTRIES_SIXTEENDAYS_WEATHER =
            "CREATE TABLE " + SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_TABLE_NAME + " (" +
                    SIXTEENDAYS_WEATHER._ID + " INTEGER PRIMARY KEY," +
                    SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DT + " TEXT," +
                    SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_DAY + " TEXT," +
                    SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MIN + " TEXT," +
                    SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MAX + " TEXT," +
                    SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_NIGHT + " TEXT," +
                    SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_EVE + " TEXT," +
                    SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_COLUMN_MORN + " TEXT)";

    public static final String SQL_DELETE_ENTRIES_SIXTEENDAYS_WEATHER =
            "DROP TABLE IF EXISTS " + SIXTEENDAYS_WEATHER.DATABASE_TABLE_SIXTEENDAYS_WEATHER_TABLE_NAME;





}
