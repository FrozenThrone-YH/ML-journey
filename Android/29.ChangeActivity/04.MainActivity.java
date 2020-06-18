package com.example.mychangeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
        button2 = (Button)findViewById(R.id.button2); //Link

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
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //웹 화면으로 이동하기 위한 준비 - intent 객체 생성
                //API정보에서 ACTION_XXX를 한번씩 보기
                Intent intent = new Intent(Intent.ACTION_VIEW);

                //.setData() - 데이터 설정
                // uri : 어떠한 정보나 위치를 가지고 있는 데이터 (ip주소, 웹주소 등)
                // Uri : 해당 주소로 표현되는 데이터를 가지고 있는 클래스
                // parse를 변환정도 생각하면 된다
                // Uri.parse : uri에 맞게 변환하겠다.
                //웹은 http://를 시작해줘야 한다.
                intent.setData(Uri.parse("http://www.naver.com"));

                //실행
                startActivity(intent);

                //FLAG_ACTIVITY_CLEAR_TOP
                // : 설정된 경우 시작중인 활동이 이미 현재 작업에서 실행 중이면 활동의 새 인스턴스를 시작하는 대신
                // 해당활동의 다른 모든 활동이 닫히고 이 의도는 (현재 맨 위) 새로 운 의도로서의 오래된 활동
                // => 이미 활도 중인 녀석을 중지 시키고, 실행할 녀석을 맨 위로 올린다.
                //FLAG를 다는 이유, 액티비티를 실행할 예정
            }
        });
    }
}
