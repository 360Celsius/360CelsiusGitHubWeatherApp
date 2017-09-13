package com.celsius.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ahrenheit.celsius.activities.R;
import com.celsius.activities.base.BaseActivity;
import com.celsius.dbhelper.DatabaseHelper;
import com.celsius.interfaces.DBHelperListenerInterface;
import com.celsius.recivers.ResponseReceiver;
import com.celsius.services.WeatherPullService;
import com.celsius.services.WeatherPullServicePutExtraKry;

public class LiveActivity extends BaseActivity implements DBHelperListenerInterface {

    private ResponseReceiver receiver;
    private RelativeLayout currentButton;
    private RelativeLayout fiveDaysButton;
    private RelativeLayout sixteenDaysButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_activity);

        //get main info data
        Intent msgIntentMainData = new Intent(getApplicationContext(), WeatherPullService.class);
        msgIntentMainData.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_MAIN_INFO_WEATHER_DATA);
        startService(msgIntentMainData);

        //send current weather intent but send 5 days data in order to show 3 days.
        Intent msgIntentFiveDaysData = new Intent(getApplicationContext(), WeatherPullService.class);
        msgIntentFiveDaysData.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_THREE_DAYS_WEATHER_DATA);
        startService(msgIntentFiveDaysData);

        currentButton = (RelativeLayout) findViewById(R.id.currentButton);
        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(getApplicationContext(), WeatherPullService.class);
                msgIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA);
                startService(msgIntent);
            }
        });
        fiveDaysButton = (RelativeLayout) findViewById(R.id.fiveDaysButton);
        fiveDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(getApplicationContext(), WeatherPullService.class);
                msgIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_FIVE_DAYS_WEATHER_DATA);
                startService(msgIntent);
            }
        });
        sixteenDaysButton = (RelativeLayout) findViewById(R.id.sixTeenDaysButton);
        sixteenDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(getApplicationContext(), WeatherPullService.class);
                msgIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_SIXTEEN_DAYS_WEATHER_DATA);
                startService(msgIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter(WeatherPullService.GET_WEATHER_DATA);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }

    @Override
    public DatabaseHelper getDBhelper() {
        return helper;
    }
}
