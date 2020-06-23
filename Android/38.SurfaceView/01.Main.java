package com.example.mysurfaceview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//SurfaceView
// - view를 상속받은 클래스
// - 일반적인 View는 정적인 반면 SurfaceView는 동적이다.
// - View에서는 onDraw메서드를 시스템에서 자동으로 호출한다.
// - SurfaceView를 이용해서 그리기를 시스템에 맡기는 것이 아니라
// - Thread를 통해서 강제로 화면에 그림을 그리는 역할
// - 애니메이션이나 동영상 같은 연산처리가 많이 필요한 뷰에서 사용된다.
//  - surfaceView를 surfaceHolder는 한세트
//  - surfaceHolder는 뷰의 움직임을 제어하고 속성을 저의하기 위한 객체



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new MySurfaceView(this));
    }
}
