package com.example.mystopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView timer,record;
    private ScrollView scrollView;
    private Button bt_sta,bt_rec;

    //상태를 표시하는 상수 지정
    public static final int INIT = 0; //처음
    public static final int RUN = 1; //실행중
    public static final int PAUSE = 2; //정지

    //상태값을 저장하는 변수
    public static int status =INIT;

    //기록할때 순서 체크를 위한 변수
    private int cnt = 1;

    //타이머 시간 값을 저장할 변수
    long baseTime,pauseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체화
        timer = (TextView)findViewById(R.id.timer);
        scrollView = (ScrollView)findViewById(R.id.scrollView);
        record = (TextView)findViewById(R.id.record);
        bt_sta = (Button)findViewById(R.id.bt_sta);
        bt_rec = (Button)findViewById(R.id.bt_rec);

        bt_rec.setEnabled(false); //비활성화

        bt_sta.setOnClickListener(onClickListener);
        bt_rec.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch(view.getId()){
                case R.id.bt_sta:
                    staButton();
                    break;
                case R.id.bt_rec:
                    recButton();
            }

        }
    };

    private void staButton(){
        switch (status){
            case INIT:
                //어플리케이션이 실행되고 나서 경과된 시간
                baseTime = SystemClock.elapsedRealtime();

                //핸들러 실행
                handler.sendEmptyMessage(0);
                bt_sta.setText("멈춤");
                bt_rec.setEnabled(true);

                //상태변환
                status = RUN;
                break;
            case RUN:
                //핸들러 정지
                //핸들러 정지는 removeMessages메서드로
                handler.removeMessages(0);

                //정지 시간 체크
                pauseTime = SystemClock.elapsedRealtime();
                bt_sta.setText("시작");
                bt_rec.setText("리셋");

                //상태변환
                status = PAUSE;
                break;
            case PAUSE:
                long reStart = SystemClock.elapsedRealtime();
                //멈춘시간과 다시 시작한 차 만큼 baseTime에 넣어준다.
                baseTime += (reStart - pauseTime);

                handler.sendEmptyMessage(0);

                bt_sta.setText("멈춤");
                bt_rec.setText("기록");

                status = RUN;
                break;
        }
    }

    private void recButton(){
        switch (status){
            case RUN:
                //상태가 RUN일떄 bt_rec는 기록으로 되어있다.
                //기록하는 메서드
                String timeList = record.getText().toString();
                timeList += String.format("%2d, %s\n",cnt,getTime());

                record.setText(timeList);
                cnt++;
                break;
            case PAUSE:
                //상태가 PAUSE일때 bt_rec는 리셋이었다.
                //리셋해주는 코드실행
                bt_sta.setText("시작");
                bt_rec.setText("기록");
                bt_rec.setEnabled(false);

                timer.setText("00 : 00 : 00");
                record.setText("");

                baseTime = 0;
                pauseTime = 0;

                cnt = 1;
                status = INIT;

        }
    }

    private String getTime(){
        //경과된 시간 체크
        long nowTime = SystemClock.elapsedRealtime();
        long overTime = nowTime - baseTime;

        long m = overTime/1000/60;
        long s = (overTime/1000)%60;
        long ms = (overTime) % 1000;

        String recTime = String.format("%02d:%02d:%02d",m,s,ms);

        return recTime;
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            timer.setText(getTime());

            //
            handler.sendEmptyMessage(0);
        }
    };
}
