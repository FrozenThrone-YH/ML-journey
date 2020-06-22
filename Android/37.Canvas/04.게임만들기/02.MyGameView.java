package com.example.mygameview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

public class MyGameView extends View {
    private static final int BLANK = 0; //대기상태
    private static final int PLAY = 1; //게임진행중
    private static final int DELAY = 1500; //도형 생성 시간.

    private int status;

    private ArrayList<Shape> arShape = new ArrayList<Shape>();
    private Random rnd = new Random(); //임의의 값을 구하는 클래스...

    private Activity mParent;

    public MyGameView(Context context){
        super(context);
        mParent = (Activity)context;
        status = BLANK;
        //핸들러 실행
    }

    //도형의 색상, 모양등의 속성을 관리할 수 있는 클래스(중첩클래스)
    class Shape{
        static final int RECT = 0; // 사각형
        static final int CIRCLE = 1; //원
        static final int TRIANGLE = 2; //삼각형

        int what;
        int color;
        Rect rt;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //캔버스를 검정색으로
        canvas.drawColor(Color.BLACK);

        if(status == BLANK){//대기상태일때는 종료
            return;
        }
        int idx = 0;
        for (idx =0;idx<arShape.size();idx++){
            Paint pnt = new Paint();
            pnt.setColor(arShape.get(idx).color);

            Rect rt = arShape.get(idx).rt;

            switch(arShape.get(idx).what){
                case Shape.RECT:
                    canvas.drawRect(rt,pnt);
                    break;
                case Shape.CIRCLE:
                    canvas.drawCircle(rt.left+rt.width()/2,rt.top+rt.height()/2,rt.width()/2,pnt);
                    break;
                case Shape.TRIANGLE:
                    Path path = new Path();
                    path.moveTo(rt.left + rt.width()/2,rt.top);
                    path.lineTo(rt.left,rt.bottom);
                    path.lineTo(rt.right,rt.bottom);
                    canvas.drawPath(path,pnt);
                    break;
                default:
                    break;
            }
        }

    }
    //일정 간격으로 모형을 생성하기 위한 핸들러
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {

            addNewShape();

            status = PLAY;
        }
    };

    //새로운 모형을 추가하기 위한 메서드
    public void addNewShape(){
        Shape shape = new Shape();
        int idx;

        boolean bFindIntersect;//도형이 중복되었는지를 판별하는 변수

        Rect rt = new Rect();

        while (true){
            //랜덤으로 도형 사이즈 생성
            //50~150사이의 난수를 생성...
            //rnd는 랜덤
            int size = rnd.nextInt(101)+50;

            //사각형 범위구하기
            rt.left = rnd.nextInt(getWidth());
            rt.top = rnd.nextInt(getHeight());
            rt.bottom = rt.top + size;
            rt.right = rt.left + size;

            //도형이 화면을 벗어날 경우 새로 그리기 ...
            if(rt.right >= getWidth() || rt.bottom >= getHeight()){
                continue;
            }
            bFindIntersect = false;

            for(idx=0;idx < arShape.size();idx++){
                if(rt.intersect(arShape.get(idx).rt)==true){
                    //겹치면 true
                    bFindIntersect = true;
                }
            }

            //위의 과정이 문제가 없을때만 while 탈출
            //겹치지도 않고, 범위 안에서 
            if(bFindIntersect == false){
                break;
            }
        }
    }
}
