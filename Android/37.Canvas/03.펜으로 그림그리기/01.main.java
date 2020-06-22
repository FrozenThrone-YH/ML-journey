package com.example.mycanvasactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

//그림을 그리는 Canvas, Paint 객체를 사용하여 그려보자..

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setContentView(new MyView(this));

        //디바이스 회전시 값 유지를 위한 코드
        //리소스 시스템을 받아서 리소스안에다가 객체를 넣어준다.
        Resources r = Resources.getSystem();
        Configuration config = r.getConfiguration();
        onConfigurationChanged(config);

    }
    //onConfigurationChanged
    //오버라이드를 했을 경우 회전시마다 onCreate메서드를 호출하므로
    //재호출하지 않도록 manifest에 속성두가지를 추가해주면 된다.
//            <activity android:name=".MainActivity"
//    android:configChanges="orientation|keyboardHidden|screenSize"
//    android:windowSoftInputMode="stateHidden|adjustPan">
    //Activity가 여러개라면 모든 액티비티에 속성을 추가해주는 것이 좋다.
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //현재 디바이스의 방향성을 체크
        switch(newConfig.orientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                Toast.makeText(getApplicationContext(),"가로",Toast.LENGTH_SHORT).show();
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                Toast.makeText(getApplicationContext(),"세로",Toast.LENGTH_SHORT).show();
                break;
                //화면이 돌아갈때마다 그림을 그린게 사라진다.
                //그것은 화면이 돌아갈때마다 재호출을 해서 그렇다.
                //속성값을 추가해서 유지하고자 하낟.
        }
    }
}
