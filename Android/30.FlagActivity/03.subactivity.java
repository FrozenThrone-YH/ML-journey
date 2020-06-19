package com.example.myflagactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

public class subactivity extends Activity {

    private Button btn_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        // manifests에 클래스 등록 <activity android:name=".subactivity"/>
        btn_prev = (Button)findViewById(R.id.btn_prev);
    }
}
