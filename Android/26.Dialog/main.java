package com.example.mydialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button button,button2,button3;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체화
        button = (Button)findViewById(R.id.button);

        //리스너 설정
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //버튼 클릭시 다이알로그 생성
                dialog = new Dialog(MainActivity.this,R.style.Dialog);

                //생성자, Contexxt가 무조건 들어 간다고 보면 된다.
                // - Dialog(Context context)기본 다이얼로그 테마
                // - Dialog(Context context,int themeResId) - 커스텀 다이얼로그 스타일 사용하여
                //    윈도우 작성한다.

                //타이틀설정
                dialog.setTitle("타이틀 설정");

                //다이얼로그 설정시 왠만하면 setContentView 위에 작성하는 것이 좋다.

                //다이틀 없애기
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                //뒷부분 반투명화 없애기
                dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                //다이얼로그 자체 조명을 투명하게
                
                

                //인플레이션 진행
                dialog.setContentView(R.layout.dialog_layout);

                //버튼 객체화
                button2 = (Button)dialog.findViewById(R.id.button2);
                button3 = (Button)dialog.findViewById(R.id.button3);

                button3.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();//다이얼로그 닫기

                    }
                });
                dialog.show();
            }
        });
    }
}
