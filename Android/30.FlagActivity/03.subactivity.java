package com.example.myflagactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(subactivity.this,MainActivity.class);

                //setFlags를 안하면 액티비티들이 stack이 된다.
                //Intent.FLAG_ACTIVITY_CLEAR_TOP
                // 이미 존재하고 있을 경우 새로운 인스턴스를 생성하는 것이 아니라
                // 존재하고 있는 액티비티를 포그라운드로 가져올때
                // 호출 인스턴스까지의 모든 액티비티를 삭제 한다.
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                //Intent.FLAG_ACTIVITY_SINGLE_TOP
                // - ACTIVITY를 호출할 경우 ACTIVITY가 현재 테스크 최 상단에
                // 존재한다면 새로운 인스턴스를 생성하지 않습니다.
                // main 호출될때마다 sub가 생성될 수 있다. sub이 top에 있으면 더이상 생성하지 않는다.
                //FLAG를 화면 제어로 생각하면 된다. 

                startActivity(intent);
            }
        });

    }
}
