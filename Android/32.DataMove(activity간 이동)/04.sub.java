package com.example.mydatamove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SubActivity extends Activity {

    private TextView text1,text2,text3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        //객체화
        text1  = (TextView)findViewById(R.id.text1);
        text2  = (TextView)findViewById(R.id.text2);
        text3  = (TextView)findViewById(R.id.text3);

        //intent 받기
        Intent intent = getIntent();

        //intent로만 전달할때는 putExtra로 줬는데, 받을때는 타입명을 써줘야한다.
//        String name = intent.getStringExtra("name");
//        String age = intent.getStringExtra("age");
//        String b_day = intent.getStringExtra("b_day");

        //bundle로 전달한거 받기
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        String age = bundle.getString("age");
        String b_day = bundle.getString("b_day");

        //intent보다는 bundle을 많이쓴다. 
        
        text1.setText(name);
        text2.setText(age);
        text3.setText(b_day);
    }
}
