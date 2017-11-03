package com.celsius.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ahrenheit.celsius.activities.R;
import com.celsius.activities.base.BaseActivity;
import com.celsius.dbhelper.DatabaseHelper;
import com.celsius.interfaces.DBHelperListenerInterface;
import com.celsius.interfaces.SpinnerInterface;
import com.celsius.recivers.ResponseReceiver;
import com.celsius.services.WeatherPullService;
import com.celsius.services.WeatherPullServicePutExtraKry;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class LiveActivity extends BaseActivity implements DBHelperListenerInterface,SpinnerInterface {

    private ResponseReceiver receiver;
    private RelativeLayout currentButton;
    private RelativeLayout fiveDaysButton;
    private RelativeLayout sixteenDaysButton;

    private TextView currentButtonText;
    private TextView fiveDaysButtonText;
    private TextView sixteenDaysButtonText;

    public ProgressBar listSpinnerSub = null;
    public ProgressBar listSpinnerMain = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.live_activity);

        currentButtonText = (TextView) findViewById(R.id.currentButtonText);
        fiveDaysButtonText = (TextView) findViewById(R.id.fiveDaysButtonText);
        sixteenDaysButtonText = (TextView) findViewById(R.id.sixTeenDaysButtonText);

        currentButtonText.setTextColor(Color.LTGRAY);
        fiveDaysButtonText.setTextColor(Color.WHITE);
        fiveDaysButtonText.setTextColor(Color.WHITE);

        //get external ip
        Intent msgIntentGetExternalIP = new Intent(getApplicationContext(), WeatherPullService.class);
        msgIntentGetExternalIP.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_EXTERNAL_IP_DATA);
        startService(msgIntentGetExternalIP);
        /////////////////////////////////////////////////////

        currentButton = (RelativeLayout) findViewById(R.id.currentButton);
        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentButtonText.setTextColor(Color.LTGRAY);
                fiveDaysButtonText.setTextColor(Color.WHITE);
                sixteenDaysButtonText.setTextColor(Color.WHITE);                Intent msgIntent = new Intent(getApplicationContext(), WeatherPullService.class);
                msgIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_CURRENT_WEATHER_DATA);
                startService(msgIntent);
            }
        });
        fiveDaysButton = (RelativeLayout) findViewById(R.id.fiveDaysButton);
        fiveDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentButtonText.setTextColor(Color.WHITE);
                fiveDaysButtonText.setTextColor(Color.LTGRAY);
                sixteenDaysButtonText.setTextColor(Color.WHITE);                Intent msgIntent = new Intent(getApplicationContext(), WeatherPullService.class);
                msgIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_FIVE_DAYS_WEATHER_DATA);
                startService(msgIntent);
            }
        });
        sixteenDaysButton = (RelativeLayout) findViewById(R.id.sixTeenDaysButton);
        sixteenDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentButtonText.setTextColor(Color.WHITE);
                fiveDaysButtonText.setTextColor(Color.WHITE);
                sixteenDaysButtonText.setTextColor(Color.LTGRAY);                Intent msgIntent = new Intent(getApplicationContext(), WeatherPullService.class);
                msgIntent.putExtra(WeatherPullServicePutExtraKry.GET_WEATHER_ACTION_KEY, WeatherPullServicePutExtraKry.GET_SIXTEEN_DAYS_WEATHER_DATA);
                startService(msgIntent);
            }
        });

        listSpinnerMain = (ProgressBar) findViewById(R.id.list_spinner_main);
        listSpinnerSub = (ProgressBar) findViewById(R.id.list_spinner_sub);

        listSpinnerSub.setVisibility(View.VISIBLE);
        listSpinnerMain.setVisibility(View.VISIBLE);


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

    @Override
    public ProgressBar getMainSpinner() {
        return listSpinnerMain;
    }

    @Override
    public ProgressBar getSubSpinner() {
        return listSpinnerSub;
    }

}
