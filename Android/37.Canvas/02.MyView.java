package com.example.mycanvasactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    public MyView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //그림을 그리는 메서드
        super.onDraw(canvas);

        //그림을 그리기 위해서 필요한 붗과 같은 객체
        //Paint
        Paint paint = new Paint();

        //Paint 객체에 색상 정하기
        paint.setColor(Color.BLUE);

        //캔버스에 그림을 그린다.
        //사각형 범위 지정
        //사각형(left,top,right,bottom, paint 객체
        //숫자의 의미 왼쪽 상단 모서리 기준으로 left 마진이 100, top 위가 200
        //그리고자 하는 오른쪽 하단 기준으로 bottom margin이 parent 위쪽부터 400
        //그리고자 하는 오른쪽 하단 기준으로 right margint은 parent 왼쪽 기준으로부터 300
        canvas.drawRect(100,200,300,400,paint);

        //원(x축,y축, 반지름, paint객체)
        //원의 중심점 기준으로 left와 top으로부터 margin, 반지름
        canvas.drawCircle(200,600,100,paint);

        paint.setColor(Color.RED);

        canvas.drawRect(100,100,200,200,paint);

        //테두리만 있는 상자
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        canvas.drawRect(200,100,300,200,paint);


    }
}
