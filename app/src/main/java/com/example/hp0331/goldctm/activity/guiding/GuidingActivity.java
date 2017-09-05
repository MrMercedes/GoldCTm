package com.example.hp0331.goldctm.activity.guiding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp0331.goldctm.R;
import com.example.hp0331.goldctm.activity.main.MainActivity;
import com.example.hp0331.goldctm.views.IndexChangeView;

import java.util.ArrayList;
import java.util.List;

public class GuidingActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;
    private TextView loginActivity;
    private IndexChangeView mIndexCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guiding);
        initViews();
    }

    @SuppressLint("InflateParams")
    private void initViews() {

        LayoutInflater inflater = LayoutInflater.from(this);
        mIndexCV = (IndexChangeView) findViewById(R.id.indexChangeView1);
        mIndexCV.setViewColorChange(0);

        views = new ArrayList<View>();
        View fViews = inflater.inflate(R.layout.guide_adapterview, null);
        ((TextView)fViews.findViewById(R.id.first_login)).setVisibility(View.GONE);

        View sViews = inflater.inflate(R.layout.guide_adapterview, null);
        ((ImageView) sViews.findViewById(R.id.guide_image)).setImageResource(R.mipmap.pic2);
        ((TextView)sViews.findViewById(R.id.first_login)).setVisibility(View.GONE);

        View tViews=inflater.inflate(R.layout.guide_adapterview,null);
        ((ImageView) tViews.findViewById(R.id.guide_image)).setImageResource(R.mipmap.pic3);
        views.add(fViews);
        views.add(sViews);
        views.add(tViews);
        vpAdapter = new ViewPagerAdapter(this, views);
        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);

        loginActivity = (TextView) views.get(2).findViewById(R.id.first_login);

        loginActivity.setOnClickListener(this);
        vp.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int arg0) {
        if (arg0 == 0) {
            mIndexCV.setViewColorChange(arg0);
        } else {
            mIndexCV.setViewColorChange(arg0);
        }
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(GuidingActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
