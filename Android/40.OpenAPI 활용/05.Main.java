package com.example.mynaveractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //pw : A6Afzc5h3n
    //ID : Lc5JmvH14jGZHF41p1RA

    private ListView myListView;
    public static EditText search; //검색어 - static 선언 안하면 다른 클래스에서 매개변수로 받아야 한다.
                                   //그때 그때 쓸려고 static으로 만들어 줬다.
    private Button search_btn;
    private Parser parser;
    private ArrayList<BookModel> list;
    private ViewModelAdapter adapter;

    private int start = 1; //검색을 시작할 인덱스 번호
    private ProgressDialog dialog_progress; //로딩을 위한 다이얼로그

    //스크롤하면 또 추가 되어야 한다.
    //스크롤링을 통한 추가 로드를 위해 필요한 변수들
    private LayoutInflater mInflater;
    private View footerView;
    private boolean nLockListView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog_progress = new ProgressDialog(this);
        dialog_progress.setMessage("Loading...");

        //객체화
        myListView = (ListView)findViewById(R.id.myListView);

        //리스트뷰의 오버스크롤 이펙트 제거
        myListView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        search = (EditText)findViewById(R.id.search);
        search_btn = (Button)findViewById(R.id.search_btn);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //검색을 하려고 버튼을 눌렀다.
                //서버연결과 결과를 받는 싱크 클래스를 만들어야 한다.
                //Async는 백그라운드내에서 서버와 연결해서 작업할 수 있게끔 동기화 시켜주는 것.
                //결론적으로 thread다.

            }
        });
    }
    //AsyncTask클래스 생성시 나오는 세개의 제너릭 타입
    //AsyncTask<Params,Progress,Result>
    // Params : doInBackground안에 들어갈 파라미터로 전달되는 매개변수
    // Progress : UI의 진행상태를 관리하는 메서드중에 onProgressUpdateaptjemrk
    //            오버라이딩 되었을때 이 메서드에서 사용되는 자료형을 지정
    // Result : 싱크쓰레드의 작업 결과를 반영하는 onPostExcute로 전달되는 객체
    // 객체가 생성될때 최초로 호출되는 메서드는 onPreExcute이다.
    // background 작업을 수행하기 전에 필요한 초기화 작업들을 담당한다.
    // 따라서 로딩을 위한 dialog.show()를 onPreExcute에서 호출하는 경우도 존대한다.

    // 두번째로 실행되는 메서드가 doInbackground가 호출된다.
    // 각종 반복이나 제어등 주된 처리 로직을 관리하는 메서드
    // 이 메서드는 반드시 오버라이드가 되어야 한다.
    class NaverAsync extends AsyncTask<String,String,ArrayList<BookModel>> {
        @Override
        protected ArrayList<BookModel> doInBackground(String... strings) {
            return parser.connectNaver(start,list);
        }
        //doInBackground가 실행되서 나오는 결과값이 onPostExcute로 간다.
        //이게 연결되는 것은 자동이다.

        @Override
        protected void onPostExecute(ArrayList<BookModel> bookModels) {
            //doInBackground가 통신을 마친 결과가 onPostExecute에 result로 넘어온다.
            //이결과를 이용해서 리스뷰의 화면을 갱신하면 된다.
            if(adapter != null){
                //result로 받은 bookModels로 adapter갱신해야 한다.
                adapter = new ViewModelAdapter(MainActivity.this,R.layout.book_view,bookModels);

                //리스트뷰에 리스너 등록
                myListView.setOnScrollListener(scrollListener);

                //리스트뷰에 footer등록.. 반드시 setAdapter전에 해야 한다.
                myListView.addFooterView(footerView);

                //리스트 뷰에 어뎁터 셋팅
                myListView.setAdapter(adapter);
            }
            adapter.notifyDataSetChanged();
            nLockListView = false;
            dialog_progress.dismiss();
        }
    }; // NaverAsync 클래스 끝
    AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView absListView, int i) {
            //현재 리스트 뷰의 상태를 알려주는 메서드
            // scrollState로 넘어오는 상태값은 3가지
            // - 1. SCROLL_STATE_FLING(2)
            //  - 터치 후 손을 땐 상태에서 아직 스크롤이 되고 있는 상황
            // - 2. SCROLL_DILE (0)
            //  - 스크롤이 종료되어 어떠한 애니메이션도 발생하지 않는 상태
            // - 3. SCROLL_TOUCH_SCROLL (1)
            //  - 스크린에 터치를 한 상태에서 크스롤 하는 상태
        }

        @Override
        public void onScroll(AbsListView absListView, int i, int i1, int i2) {
            //스크롤이 발생하는 동안 지속적으로 호출되는 메서드
            // int i : firstVisibleItem = 현재 보여지는 리스트 뷰에서 상단에 보여지는 항목의 인덱스
            // int i1 : visibleItemCount = 현재 리스트 뷰에서 보여지는 항목의 수
            // int i2 : totalItemCoutn = 현재 리스트 뷰의 총 항목의 수를 알려준다.

            //제일 필요하는 건 제일 밑으로 갔을 때 view가 갱신되는 것.
        }
    };
}
