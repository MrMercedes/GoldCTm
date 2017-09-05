package com.example.hp0331.goldctm.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.hp0331.goldctm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }



}
