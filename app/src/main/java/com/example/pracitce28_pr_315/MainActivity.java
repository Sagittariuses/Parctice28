package com.example.pracitce28_pr_315;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private static final int SWIPE_MAX_DISTANCE = 300;
    private GestureDetectorCompat lSwipeDetector;
    Button BtnNewAct;
    RelativeLayout main_layout;
    int i;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnNewAct = findViewById(R.id.BtnNewAct);
        BtnNewAct.setOnClickListener(this::onClick);
        i = 1;
        lSwipeDetector = new GestureDetectorCompat(this, new MyGestureListener());
        main_layout = findViewById(R.id.main_layout);

        main_layout.setOnTouchListener((v, event) -> lSwipeDetector.onTouchEvent(event));

    }
    private  void onClick(View v){
        Intent intent = new Intent(MainActivity.this, ButtonJava.class);
        startActivity(intent);

    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_DISTANCE)
                return false;

            Intent intent = new Intent(MainActivity.this, SwipeLeft.class);
            startActivity(intent);
            return false;
        }
    }
}