package com.example.mysurfaceview;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MyThread extends Thread{

    private MySurfaceView surface;
    private SurfaceHolder holder;

    public MyThread(MySurfaceView surface,SurfaceHolder holder){
        this.surface = surface;
        this.holder = holder;
    }

    @Override
    public void run() {
        //surfaceView의 x값을 변경 후에 ondraw를 호출 할 것이다. (x값 변경하면서)
        //우선 onDraw를 호출하기 위해서 canvas를 얻어 내야 한다.
        //Canvas는 holder가 가지고 있다.

        Canvas c = null;
        try{//Thread가 돌아가는 도중 앱이 종료되면서 예상치 못한 종료가
            //에러를 유발하기 때문에 예외처리를 통해 while문을 감싸 줌으로 이를 방지한다.
            //앱 종료될대 문제가 되기때문에 try catch 걸어준다.
            while(true){
                try{
                    Thread.sleep(50);
                    //이미지의 x값이 현재창의 너비를 벗어나면 반복문 탈출
                    //이미지 크기가 72x72이다.
                    if(surface.getImg_x() >= surface.getWidth()-72){
                        break;
                    }

                    //x값 증가
                    int x = surface.getImg_x() + 5;

                    //증가된 값을 SurFaceView에 저장
                    surface.setImg_x(x);


                    c = holder.lockCanvas();

                    surface.draw(c);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                holder.unlockCanvasAndPost(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        }
    }


