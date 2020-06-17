package com.example.myalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    //뒤로 가기 버튼을 누르면 다이얼로그가 호출되도록

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //키가 눌려졌을때 실행되는 메서드

        //키가 눌러졌을때를 처리할 것이기 때문에 if를 적는다.
        if (event.getAction() == KeyEvent.ACTION_DOWN){
            //KEYCOD_BACK이 뒤로가기 버튼
            if(keyCode == KeyEvent.KEYCODE_BACK){
                //alertDialog 객체 생성

                //alertDialog 구성 => AlertDialog.Builer
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                //AlertDialog의 버튼 종류
                // 1. PositiveButton : 확인
                // 2. NagativeButton : 취소
                // 3. NeutralButton : 중립??

                //버튼은 각각 정의하는 것을 권장한다.
                //두개 이상 중복되면 마지막으로 등록한 버튼으로 갱신이된다.

                //뒤로 버튼을 눌렀을때 다이얼로그 띄운다.=> 어플리케이션 종료
                //DialogInterface 안에 onClickListener가 따로 있다.
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //어플리케이션 종료
                        // - finish(); 액티비티를 숨기고(hide), 실행중인 코드를 멈추고(stop), 소멸(destroy)하지만 프로세스는 살아 있다. (앱은 실행은 된다.)
                        //             어플리케이션 실행중에 액티비티를 닫을 때 수행한다.
                        // - 현재 발견된 문제점?
                        //   System.exit()로 앱이 종료될때 프로세스들이 완전히 종료하지 못한다는 의견이 분분하다.
                        // - android.os.Process.killProcess(android.os.Process.myPid());를 사용하는 사람들도 있다.

                        //프로세스(실행중인 앱) 종료하고 모든 리소스를 반환한다.
                        // status 0 이면 정상 종료 0이 아니면 비정상 종료
                        System.exit(0);
                    }
                });

            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
