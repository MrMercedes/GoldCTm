package com.example.hp0331.goldctm.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


import com.example.hp0331.goldctm.R;

import java.util.ArrayList;

/**
 * Created by Aaron.zhang
 * at  2017/9/1.
 */

public class IndexChangeView extends View{
    public static final int ORANGE = 0xff7f00;
    //	public static final int PURPLE = 0xee82ee;
    private Paint first;
    private Paint second;

    private int currentIndex = 0;
    private final float RADIUS = 5;
    private int number = 4;
    private ArrayList<Float> widthLists;

    private float height = 0;

    public IndexChangeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IndexChangeView);


        number = a.getInt(R.styleable.IndexChangeView_number, 2);

        a.recycle();
        init();
    }

    public IndexChangeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IndexChangeView, defStyleAttr, 0);


        number = a.getInt(R.styleable.IndexChangeView_number, 2);

        a.recycle();
        init();

    }

    private void init() {
        // TODO Auto-generated method stub

        first = new Paint();
        first.setAntiAlias(true);
        first.setColor(Color.RED);
        second = new Paint();
        second.setAntiAlias(true);
        second.setColor(Color.GRAY);
        this.getWidth();
        this.getHeight();
        widthLists = new ArrayList<Float>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) { // TODO
        // Auto-generated
        // method
        // stub
        super.onSizeChanged(w, h, oldw, oldh);

        height = h / 2;
        int half;
        if (number % 2 == 0) {

            half = number / 2;
        } else {
            half = (number - 1) / 2;
        }
        for (int i = 0; i < number; i++) {


            if (number % 2 == 0) {

                if (half - 1 == i) {

                    float temp = w / 2 - 10;
                    widthLists.add(i, temp);
                } else if (half == i) {
                    float temp = w / 2 + 10;
                    widthLists.add(i, temp);
                } else if (i < half - 1) {
                    float temp = w / 2 - ((half - (i + 1)) * 20 + 10);
                    widthLists.add(i, temp);
                } else if (i > half) {
                    float temp = w / 2 + ((i - half) * 20 + 10);
                    widthLists.add(i, temp);
                }

            } else {



                if (i == half) {

                    float temp = w / 2;
                    widthLists.add(i, temp);
                } else if (i < half) {

                    float temp = w / 2 - ((half - i) * 20);
                    widthLists.add(i, temp);
                } else {
                    float temp = w / 2 + ((i - half) * 20);
                    widthLists.add(i, temp);
                }

            }

        }

    }

    public void setViewColorChange(int i ) {

        currentIndex = i;
        postInvalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generatedmethod stub
        super.onDraw(canvas);


        for (int i = 0; i < number; i++) {
            Log.i("TAG", "folat:-=-=-=");
            if (i == currentIndex) {

                Log.i("TAG", "currentIndex" + currentIndex);
                canvas.drawCircle(widthLists.get(i), height, RADIUS, first);
                continue;
            }

            canvas.drawCircle(widthLists.get(i), height, RADIUS, second);

        }

    }
}
