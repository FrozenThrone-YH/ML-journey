package com.example.myintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textName,textMarry,textGender,textBlood;
    private Button btn_change;
    private String name,bloodtype;
    private boolean box_checked;
    private int gender_btn_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //저장된 정보 불러오기
        SharedPreferences pref = getSharedPreferences("Save_info", Context.MODE_PRIVATE);
        name = pref.getString("name","name");
        box_checked = pref.getBoolean("box_checked",false);
        gender_btn_num = pref.getInt("gender",0);
        bloodtype = pref.getString("blood","bloodType");

        //객체화
        textName = (TextView)findViewById(R.id.textName);
        textMarry = (TextView)findViewById(R.id.textMarry);
        textBlood = (TextView)findViewById(R.id.textBlood);
        textGender = (TextView)findViewById(R.id.textGender);

        textName.setText(name);
        textBlood.setText(bloodtype);

        if (box_checked){
            textMarry.setText("기혼");
        } else{
            textMarry.setText("미혼");
        }
        if (gender_btn_num == R.id.radio_gender_male){
            textGender.setText("남자");
        }else if(gender_btn_num == R.id.radio_gender_female){
            textGender.setText("여자");
        }else{
            textGender.setText("남자/여자");
        }

        btn_change = (Button)findViewById(R.id.btn_change);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SubActivity.class);

                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(i);
            }
        });
    }
}
