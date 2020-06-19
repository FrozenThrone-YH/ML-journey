package com.example.myhandlerwhat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//Handler의 What
//  - what은 핸들러 내부에서 값을 구분하기 위한 코드...
//  - 여러가지 상황에서 따로따로 실행할 수 코드를 별도로 둔다.

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btn0,btn1;
    private long time,now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        textView = (TextView)findViewById(R.id.textView);

        btn0.setOnClickListener(click);
        btn1.setOnClickListener(click);
        }

        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.btn0:
                        handler.sendEmptyMessage(0);
                        //현재 어플리케이션이 실행되고 나서 경과된 시간구하는 메서드?
                        time = SystemClock.elapsedRealtime();
                        break;
                    case R.id.btn1:
                        //what을 1로
                        now = SystemClock.elapsedRealtime();
                        long over = now - time;

                        String ti = String.format("%02d : %02d : %02d",(over/1000/60),(over/1000%60),(over%1000/10));
                        textView.setText(ti);
                        handler.sendEmptyMessage(1);
                        break;

                }
            }
        };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //message class 안에 what이 있다.
            switch(msg.what){
                case 0:
                    Toast.makeText(getApplicationContext(), "What : 0", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "What : 1", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}
