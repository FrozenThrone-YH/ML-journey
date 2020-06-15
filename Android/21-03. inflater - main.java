package com.example.mylayoutinflator;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/*
 레이아웃 인플레이션
   - 하나의 Activity는 두개의 파일로 이루어진다. .xml과 .java가 한 세트다.
   - 쉽게 생각할때, xml을 디자인 측면, java파일은 기능 측면
   - 두개의 파일이 한세트라는 것을 알려줘야 한다.그것을 알려주는 것이 setContentView 메서드를 통해
      xml파일과 java파일을 매칭한다.

  인플레이션
   - xml 레이아웃에 정의된 내용이 메모리에 객체화 되는 과정을 인플레이션이라고 한다.
   - R.id.list_form_txt 불러오는게 메모리에 객체화 되어있는 것이다.
   - 객체화는 inflate가 시킨 것이다.
   - MainActivity는 setConentView가 객체화 시킨다.
   - 인플레이션이 진행되었기 때문에 객체를 가져올 수 있다.
   - 우리가 프로젝트를 실행하게 되면 이때 인플레이터가 xml파일의 태그들을 객체화 시켜 메모리에
     만들어 주고 그것을 이용하여 어플리케이션이 작동하게 된다.
   - 인플레이션은 setContentView가 실행이 되어야 가능하다.
   - setContentView 메서드가 실행이 되기전에 findViewById를 통해 객체를 불러오면
     null값을 받기 때문에 객체 사용 불가.


 */

public class MainActivity extends AppCompatActivity {

    private FrameLayout container;
    private Button button,button2;
    private TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main만 객체화가 되어 있다.
        setContentView(R.layout.activity_main);

        container = (FrameLayout)findViewById(R.id.container);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //인플레이션을 진행할 수 있게 준비하는 객체가 필요
                // LayoutInflater
                // getSystemService() - LayoutInflater를 만들어주는 메서드
                // -Context.LAYOUT_INFLATOR_SERVICE
                //  - layout_inflator - 서비스 이름이 문자열 상수로 지정되어있다.

                // 다시 정리
                // 내가 레이아웃 인플레이터 객체를 만들기 위해서 시스템 상에 있는 인플레이터 객체를 가져와야 하는데
                // 일단 걔를 구분 지을 수 있는 이름으로써 상수 값을 만들어 놓았다.
                // 이거말고 Context. 하고 나오는 건 몇가지 된다. SERVICE들
                // 그 중에 레이아웃 인플레이터 서비스라는 녀석이 우리가 이걸 통해서 만들어져있는
                // 인플레이터 객체를 가져올 수 있다.
                // 그래서 getSystemService 메서드 안에 서비스 이름을 집어 넣으면
                // 레이아웃 인플레이터 객체를 반환해준다. 캐스팅을 안하면 error다 .
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //준비끝

                //인플레이션 진행 - inflate
                //public inflate(@LayoutRes int resource,android.view.ViewGroup root,
                //                boolean attachToroot))
                //int resource - 실행할 레이아웃의 상수 값 => sub1이 된다.
                //android.view.ViewGroup root - 인플레이션을 진행하여 넣을 뷰그룹
                //  => frameLayout에 넣을거니까 container
                //boolean attachToRoot - 진행을 언제 할지.. true는 바로 실행
                View convertView = layoutInflater.inflate(R.layout.sub1,container,true);
                //inflate하고 나면 반환값이 view이다.

                button2 = (Button)convertView.findViewById(R.id.button2);
                textView2 = (TextView)convertView.findViewById(R.id.textView2);

                button2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        textView2.setText("만들었다.");
                    }
                });
            }
            }
        );

    }
}
