package com.example.hp0331.goldctm.activity.welcome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hp0331.goldctm.R;
import com.example.hp0331.goldctm.activity.main.MainActivity;
import com.example.hp0331.goldctm.activity.guiding.GuidingActivity;
import com.example.hp0331.goldctm.application.MyApplication;
import com.example.hp0331.goldctm.utils.ContantValues;

import java.lang.ref.WeakReference;

public class WelcomeActivity extends AppCompatActivity {
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;
    private static final int TIME = 1000;
    private boolean isFirstIn = false;

    private MyHandler mMyHandler;

    static class MyHandler extends Handler {
        WeakReference<Activity> mActivity;

        MyHandler(WelcomeActivity activity) {
            mActivity = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            WelcomeActivity welcomeActivity = (WelcomeActivity) mActivity.get();
            switch (msg.what) {
                case GO_GUIDE:
                    welcomeActivity.goGuide();
                    break;
                case GO_HOME:
//                    welcomeActivity.goHome();
                    welcomeActivity.goGuide();
                    break;
            }
            super.handleMessage(msg);
        }
    }
    private void goHome() {
        Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void goGuide() {
        Intent i = new Intent(WelcomeActivity.this, GuidingActivity.class);
        startActivity(i);
        finish();
    }
    private void init() {

        if (!MyApplication.isFirstIn) {
            mMyHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
        } else {
            logIn();
            mMyHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
            SharedPreferences.Editor editor = MyApplication.perPreferences.edit();
            editor.putBoolean(ContantValues.ISfRIST, false);
            editor.commit();
        }

    }
    public boolean logIn(){
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mMyHandler = new MyHandler(this);
        init();
    }
}
