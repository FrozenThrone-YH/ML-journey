package com.example.mysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Shared Preperences
//  - 일반적으로는 정보들을 저장할때 DB를 사용한다.
//  - DB를 쓰기에는 너무 간단한 것들을 사용하려면 낭비가 된다.
//  - 간단한 정보를 파일형석으로 디바이스에 저장하는 용도...
//  - 디바이스가 종료되거나 혹은 휴대폰을 재시작하여도 계속 유지가 될 수 있다.
//  - 간단한 세이브 파일 용도로 사용되기 적합하다.
//  - Bundle과 같이 key값과 value값으로 지정하여 다른 액티비티로 전달하는 것이 가능하다.

// value버튼 누를때마다 숫자가 계속 증가되는 것을 만든다
public class MainActivity extends AppCompatActivity {

    private TextView value;
    private Button btn_value,btn_reset;
    private int n = 0;
    private EditText edit_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //앱이 실행될때 저장되는 값을 로드 ...
        SharedPreferences pref = getSharedPreferences("Save",Context.MODE_PRIVATE);
        //int i는 설정이 안됐을때 default 값이다.
        //여기서 save는 key값을 불러오는 것이다.
        n = pref.getInt("save",0);
        String name = pref.getString("input_name","name input");


        //객체화
        value = (TextView)findViewById(R.id.value);
        btn_value = (Button)findViewById(R.id.btn_value);
        btn_reset = (Button)findViewById(R.id.btn_reset);
        edit_name = (EditText)findViewById(R.id.edit_name);

        edit_name.setText(name);

        //그냥 n만 넣으면 아이디값-상수값만 들어간다.
        value.setText(n+"");
        btn_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n++;
                value.setText(n+"");
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = 0;
                value.setText(n+"");
            }
        });
    }
    //어플리케이션이 종료될때 자동으로 실행되는 메서드
    //앱 종료될때 정보를 한번에 저장하려고 한다

    @Override
    protected void onDestroy() {
        Log.i("Destroy","종료");
        super.onDestroy();
        //프로그램이 종료될떄
        //SharedPreferences 객체에 저장한다.
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        //작대기가 그어져있으면 앞으로 쓰지 않을거니까 다른거 써라
        //예전 방식이다.

        //String name, int mode = handler의 what으로 생각하면 된다.
        // name 은 파일명, mode = file 명에 대한 mode
        // Context.MODE_PRIVATE 값이 0 이다. 그래서 0으로 쓰라고 한다.
        SharedPreferences sharedPreferences
                = getSharedPreferences("Save", Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        //그안에 내용들을 구분짓기 위해서 쓰는 것이 save 키/value값이다.
        edit.putInt("save",n);

        //Edit_name에 입력된 내용 저장
        edit.putString("input_name",edit_name.getText().toString());

        edit.commit(); //저장이다. commit을 하지 않으면 저장되지 않는다.
    }
}
