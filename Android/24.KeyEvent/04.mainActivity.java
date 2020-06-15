package com.example.mykeylistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);

        //key 리스너는 key가 눌렸을때다.
        //onKeyListener
        //  - onKey메서드로 재정의 하여야 한다.
        editText.setOnKeyListener(new View.OnKeyListener(){

            //여기서 i는 keyCode이다. key값이다. 아스키코드와 유니코드와는 다르다.
            //keyEvent는 motionEvent와 사용방법이 거의 비슷하다.
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                //키가 눌렸는지 안눌렸는지 확인할때 쓴다.
                if(keyEvent.getAction() == KeyEvent.ACTION_UP){
                    //KeyEvent.ACTION_DOWN
                    // - 예전 코드들을 살펴 보면 다운으로 처리하였다.
                    // OREO버전에서는 DOWN으로 처리하면 제대로 되지 않는다.
                    // 없어도 되는데, 빠르게 두번 눌렀을때 어떻게 처리하느냐. 방지하고자

                    //키가 눌려 졌을때 0~9까지의 숫자키 거르기
                    textView.setText("Input data :" + i);
                    //KEYCODE_0은 실제로 누르는 KEY의 코드이다.
                    if(i >= KeyEvent.KEYCODE_0 && i<= KeyEvent.KEYCODE_9){
                        Toast.makeText(getApplicationContext(),"number"+i,Toast.LENGTH_LONG).show();
                    }

                }

                return false;
            }
        });


    }


    //이것이 옵션처럼 바뀌었다. 필요하면 쓰고 안필요하면 안쓰고
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
