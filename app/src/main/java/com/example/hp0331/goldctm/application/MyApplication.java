package com.example.hp0331.goldctm.application;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.hp0331.goldctm.utils.ContantValues;

/**
 * Created by Aaron.zhang
 * at  2017/9/5.
 */

public class MyApplication extends Application {
    public static  boolean isFirstIn = false;
    public static  String username = "";
    public static  String password = "";
    public static  SharedPreferences perPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        perPreferences = getSharedPreferences(ContantValues.FRISTLOGIN, MODE_PRIVATE);
        getData();
    }


    public void getData() {

        isFirstIn = perPreferences.getBoolean(ContantValues.ISfRIST, true);
        username = perPreferences.getString(ContantValues.USERNAME, null);
        password = perPreferences.getString(ContantValues.PASSWORD, null);
    }
}
