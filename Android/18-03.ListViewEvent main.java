package com.example.mylistviewevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addBtn;
    private ListView myList;
    private ArrayList<String> list;

    private int cnt = 0;
    private MyAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView에서 객체화가 된것이다.
        setContentView(R.layout.activity_main);

        addBtn = (Button)findViewById(R.id.addBtn);
        myList = (ListView)findViewById(R.id.myList);
        list = new ArrayList<String>();

        //MainActivity.this는 현재 view가 들어간것이다.
        //R.layout.list_form은 아이템으로 쓸 layout이 들어갔다.<xml파일?>
        //이 안에서 실행시키려면 list가 있어야 하고,
        //이것들이 실행될 뷰가 필요해서 myList가 들어간다.
        adapter = new MyAdapter(MainActivity.this,R.layout.list_form,list,myList);

        myList.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //버튼을 클릭할때마다 카운트를 증가시키면서 list에 내용추가
                cnt++;
                list.add("list "+cnt);

                if(myList !=null){
                    //list 값이 추가 될때마다 list뷰를 갱신한다.
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
