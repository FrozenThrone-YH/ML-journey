package com.example.myalertimage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private View view;
    private Button btn_cancel,btn_ok,button;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dialog = new Dialog(MainActivity.this);

                // dialog.xml 인플레이션 진행
                dialog.setContentView(R.layout.dialog);
                frameLayout = dialog.findViewById(R.id.frame);
                frameLayout.setVisibility(FrameLayout.VISIBLE);

                //inner_layout.xml 인플레이션 준비
                LayoutInflater layoutInflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.inner_dialog,frameLayout);

                //버튼 객체화
                btn_cancel = dialog.findViewById(R.id.btn_cancel);
                btn_ok = dialog.findViewById(R.id.btn_ok);

                //리스너 설정
                btn_ok.setOnClickListener(click);
                btn_cancel.setOnClickListener(click);

                //타이틀 설정
                dialog.setTitle("My Dialog");

                dialog.show();
            }
        });
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(view.getId()){
                case R.id.btn_cancel:
//                    frameLayout.setVisibility(FrameLayout.GONE);
                    dialog.dismiss();
                    break;
                case R.id.btn_ok:
                    finish();
                    break;
            }
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            if(keyCode == KeyEvent.KEYCODE_BACK){
//                frameLayout.setVisibility(FrameLayout.VISIBLE);
                  dialog.show();
            }
        }

        return true;
    }
}
