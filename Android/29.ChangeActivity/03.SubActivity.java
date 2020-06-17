package com.example.mychangeactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//onCreate를 해주려면 Activity를 상속해야 한다.
public class SubActivity extends Activity {

    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        button3 = (Button)findViewById(R.id.button3);

        //Intent - 안드로이드 화면 간의 이동을 위해 사용하는 객체
        //JSP의 request와 response라고 생각하면 된다.
        //화면 이동하면서 데이터도 가져갈 수 있고, 현재 화면을 닫아 놓을건지 열건지, 밑으로 깔건지 설정할 수 있는 것이 intent

        //클릭이 되었을때 이동할 수 있도록

        //인텐트는 다른 응용 프로그램의 코드간에 런타임, 런타임 바인딩을 수행하기 위한 기능을 제공합니다.
        //설명 사이트를 좀 봐야 한다. 인자가 너무 많고, 설명을 다 못해준다.
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent객체 생성
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(intent);

                finish(); //현재 Activity가 모두 끝이 났다.
            }
        });
    }
}
