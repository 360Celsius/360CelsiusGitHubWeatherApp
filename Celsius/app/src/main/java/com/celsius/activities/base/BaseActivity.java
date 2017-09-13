package com.celsius.activities.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.celsius.dbhelper.DatabaseHelper;

/**
 * Created by dennisshar on 04/09/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public static DatabaseHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        helper = DatabaseHelper.getInstance(getApplicationContext());

    }
}
