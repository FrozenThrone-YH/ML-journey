package com.example.mycanvasactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//그림을 그리는 Canvas, Paint 객체를 사용하여 그려보자..

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(new MyView(this));
    }
}
