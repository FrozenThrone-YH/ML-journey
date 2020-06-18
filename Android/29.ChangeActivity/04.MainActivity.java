package com.example.mychangeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        //리스너 설정
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티 이동
                //intent 객체 생성..

                Intent intent = new Intent();

                //이동하고자 하는 Activity가 존재하면
                //manifests에 클래스들을 등록해주어야 Activity가 인정된다.
                // <activity android:name=".SubActivity"/>
                intent.setClass(getApplicationContext(),SubActivity.class);

                // 이동!
                startActivity(intent);
            }
        });
    }
}
