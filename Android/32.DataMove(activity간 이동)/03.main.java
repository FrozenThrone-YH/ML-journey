package com.example.mydatamove;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    //날짜 입력 받을때 다이얼 로그 띄울 것이다.
    private Dialog dialog;
    private EditText edit_b_day,edit_name,edit_age;
    private Button date,send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체화
        edit_name = (EditText)findViewById(R.id.edit_name);
        edit_age  = (EditText)findViewById(R.id.edit_age);
        edit_b_day = (EditText)findViewById(R.id.edit_b_day);

        date = (Button)findViewById(R.id.date);
        send = (Button)findViewById(R.id.send);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 날짜
                //Calendar 클래스를 이용하여 구한다.
                Calendar now = Calendar.getInstance();

                int y = now.get(Calendar.YEAR);
                int m = now.get(Calendar.MONTH);
                int d = now.get(Calendar.DAY_OF_MONTH);

                //다이얼로그에서 달력뜨게 하고 싶다.
                //날짜를 처리하는 리스너가 있다. dateSetListener
                dialog = new DatePickerDialog(MainActivity.this,dateSetListener,y,m,d);

                //dialog는 항상 show();를 해줘야 한다.
                dialog.show();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환 시킬 것이다.
                //Intent객체 생성
                Intent i = new Intent(MainActivity.this,SubActivity.class);

                //데이터 넘기려면 입력된 데이터를 받아와야한다.
                String name = edit_name.getText().toString();
                String age = edit_age.getText().toString();
                String b_day = edit_b_day.getText().toString();

                //데이터를 다른 Activity를 넘기는 방법은 2가지가 있다.
                // 1번째 - intent를 통하여 전달하는 방식 (연결시켜놓은 것이라고 보면 된다. - 저쪽에서 받을 수 있다.)
                // 2번째 - Bundle을 통하여 전달하는 방식
                //        : 여러가지의 타입을 저장할 수 있게 만들어주는 Map 타입의 클래스이다.
                //        : 어차피 이것도 Intent를 통해서 만든다.
                //        : Bundle에다가 데이터를 다 넣고, intent를 통해 전달해야한다.

            }
        });

    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            //i, i1, i2가 연,월,일로 보면 된다.
                //1월이 0이 된다. 2월이 1이된다. 따라서 i1 +1 로 해준다.
                //i1은 MonthOfYear이다.
                String strDate = String.format("%d-%02d-%02d",i,i1+1,i2);

                edit_b_day.setText(strDate);
        }
    };
}
