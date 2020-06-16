package com.example.myratingbardialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button button1,button2;
    private TextView textView1;
    private RatingBar ratingBar;
    private Dialog dialog;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체화

        button1 = (Button)findViewById(R.id.button1);
        textView1 = (TextView)findViewById(R.id.textView1);

        //버튼 리스너 설정
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // 다이얼로그 객체 생성
                dialog = new Dialog(MainActivity.this);

                //인플레이션
                dialog.setContentView(R.layout.dialog);

                //객체화
                ratingBar = (RatingBar)dialog.findViewById(R.id.ratingBar);
                button2 = (Button)dialog.findViewById(R.id.button2);

                button2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //textView1.setText를 여기다 설정하면 닫을때 반영
                        textView1.setText(str + " / 10.0");
                        dialog.dismiss();
                    }
                });

                //리스너 설정 - onRatingBarChangeListener
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        //float rating은 별점이다. 별점 반칸에 0.5점

                        //별 갯수에 따른 별 한칸당 평균
                        //아까 잡아놓은 설정
                        //st는 별이 5개니까 별 하나당 2점이다.
                        //만약 별을 한개 반 하면, rating은 1.5점 거기다 2를 곱하면 3점이 된다.
                        float st = 10.0f/ratingBar.getNumStars();

                        //String 객체를 이용해서 구한 평균값을 소수점 한자리로 표현
                        str = new String().format("%.1f",(st * rating));
                        //textView1.setText를 여기다 설정하면 바로바로 반영
//                        textView1.setText(str + " / 10.0");
                    }
                });
                //다이얼로그 창 추변 부분 가능 여부
                //false면 터치 불가, true면 터치 가능
                dialog.setCanceledOnTouchOutside(false);

                dialog.show();
            }
        });

    }
}
