package com.example.mysurfaceactivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class MyView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private Thread thread;
    private Bitmap bitmap;

    private int x,y;
    private int speedX = 10,speedY=10; //속도

    private boolean check = true;

    public MyView(Context context){
        super(context);

        //이미지 가져오기
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        //holder 셋팅
        holder = getHolder();

        //Surfaceholder안에 감지하는 것 설정 필요
        holder.addCallback(this);

        //크기 설정
        holder.setFixedSize(getWidth(),getHeight());

        //Thread 정의
        thread = new Thread(){
            @Override
            public void run() {
//                super.run();
                Canvas c = null;

                try{
                    while(check){
                        try{
                            Thread.sleep(50);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //캔버스 설정
                        c = holder.lockCanvas();

                        //배경색 변경
                        //캔버스가 원래는 투명하다.
                        //앞에 붙여 넣은 캔버스가 뒤로 비춰진다.
                        //비춰지는 것을 막기 위해 배경색을 설정한다.
                        c.drawColor(Color.BLACK);

                        //캔버스에 이미지 그리기
                        //paint 객체 만들지 않아서 null 값
                        c.drawBitmap(bitmap,x,y,null);

                        //이미지를 표현하는 캔버스를 화면에 붙이기
                        holder.unlockCanvasAndPost(c);

                        //이미지의 이동을 구하는 좌표 연산
                        //72뺀것과 동일하다.
                        if(x <0 || x>getWidth()-bitmap.getWidth()){
                            speedX = -speedX;
                        }
                        if(y <0 || x>getHeight()-bitmap.getHeight()){
                            speedY = -speedY;
                        }
                        x += speedX;
                        y += speedY;

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        thread.start();
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        check = false;
        thread =null;
    }
}

//mipmap에 있는 이미지를 drawable 폴더에 옮겨주면 이미지가 실행된다. 
