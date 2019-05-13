package com.gmail.ya.anjaryuliana.belajargesture;

import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private TextView gestureText;
    private GestureDetectorCompat gDetector;
    public static final int SWIPE_TRESHOLD = 100;
    public static final int SWIPE_VELOCITY_TRESHOLD = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureText =
                (TextView)findViewById(R.id.gestureStatusText);
        this.gDetector = new GestureDetectorCompat(this,this);
        gDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText ("onDown");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
        //gestureText.setText("onFling");
        //return true;
        boolean result = false;
        float diffY = event2.getY() - event1.getY();
        float diffX = event2.getX() - event1.getX();
        if (Math.abs(diffX) > Math.abs(diffY)){
            if (Math.abs(diffX) > SWIPE_TRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_TRESHOLD){
                if (diffX > 0){
                    gestureText.setText("onSwipeRight");
                    RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_main);
                    layout.setBackgroundColor(Color.RED);
                } else {
                    gestureText.setText("onSwipeLeft");
                    RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_main);
                    layout.setBackgroundColor(Color.BLACK);
                }
                result = true;
            }
        } else {
            if (Math.abs(diffY) > SWIPE_TRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_TRESHOLD){
                if (diffY > 0){
                    gestureText.setText("onSwipeBottom");
                    RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_main);
                    layout.setBackgroundColor(Color.YELLOW);
                } else {
                    gestureText.setText("onSwipeTop");
                    RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_main);
                    layout.setBackgroundColor(Color.GREEN);
                }
                result = true;
            }
        }
        return result;
    }


    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("onLongPress");
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        return true;
    }
    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("onShowPress");
    }
    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("onSingleTapUp");
        return true;
    }
    @Override
    public boolean onDoubleTap(MotionEvent event) {
        gestureText.setText("onDoubleTap");
        return true;
    }
    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        gestureText.setText("onDoubleTapEvent");
        return true;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        gestureText.setText("onSingleTapConfirmed");
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

}