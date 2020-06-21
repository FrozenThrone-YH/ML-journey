package com.example.mythreadactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

//Thread
//  - 여러개의 코드를 동시에 실행시킬수 있게 만들 수 있는 것.
//  - 인터넷에서 찾아보면
//     쓰레드란?
//       : 스레드란 프로세스내에서 실제로 작업을 수행하는 주체를 의미합니다.
//         모든 프로세스에는 한개 이상의 스레드가 존재하여 작업을 수행합니다.
//         또한, 두개 이상의 스레드를 가지는 프로세스를 멀티스레드 프로세스라고 합니다.

public class MainActivity extends AppCompatActivity {

    //ProgressDialog는 쓰지 말라고 했지만, 다른 대안책이 없다.
    private ProgressDialog pBar;

    private Button wheel,bar;

    //쓰레드 객체 선언
    private ThreadEX threadEX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheel = (Button)findViewById(R.id.wheel);
        bar = (Button)findViewById(R.id.bar);

        wheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //프로그래스바는 기본적으로 원형을 제공한다.
                pBar = ProgressDialog.show(MainActivity.this, //context
                        "title", //타이틀
                        "Loading");//메세지

                //도중 취소 여부
                pBar.setCancelable(false);

                threadEX = new ThreadEX(handler);
                threadEX.start();
            }
        });
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //인자로 전달된 Message객체로 부터 Bundle객체를 얻어야 한다.

//            Bundle bundle = msg.getData();
//
//            //value값 추출
//            int value = bundle.getInt("value");

            int value = msg.getData().getInt("value");

            //받은 정수를 프로그래스 바의 진행값으로 설정
            pBar.setProgress(value);

            super.handleMessage(msg);

            pBar.setMessage("Loading ... " + value + "%");

            //그런다음 쓰레드가 종료되어야한다. while문 종료 시켜야한다.
            if(value >= 100){
                pBar.dismiss();
                threadEX.setCheck(false);
            }
        }
    };
}
