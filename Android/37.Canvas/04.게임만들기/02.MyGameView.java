package com.example.mymemorygame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

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
        static final int TRIANGLE = 0; //삼각형
        
        int what;
        int color;
        Rect rt;
    }
    
}
