package com.example.mysurfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    //callBack은 해당 뷰에서 일어나는 변경사항들을 감지하기 위한 메서드들을 가지고 있다.
    //Thread를 이용해서 만들것이기 때문에 Thread를 정의 하나 더 해야한다.

    private int img_x;
    private MyThread thread;

    public MySurfaceView(Context context){
        super(context);

        //surface의 뷰가 변경, 생성, 소멸될때 감지하여
        //자동으로 호출되는 각각의 메서드들이 현재 객체가 가지고 있음을 인식 시켜야 한다.

        //뷰의 움직임을 제어하고 속성을 정의하기 위해
        //holder객체를 사용한다.

        //상속받은 surfaceView클래스 내부에 getHolder를 통해
        // 현재 클래스에서 발생하는 변경사항들을 감지할 수 있도록 추가하여야 한다.

        getHolder().addCallback(this); //등록 완료

        //holder에게 현재 view의 너비와 높이를 인식 시켜야 한다.
        getHolder().setFixedSize(getWidth(),getHeight());

        thread = new MyThread(this,getHolder());


    }
    //여기까지 해도 맨위에 빨간색, surfaceCreated를 만들어 줘야한다.


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //SurfaceView가 생성될때 호출되는 메서드
        thread.start();
    }
    //여기까지 해도 맨위에 빨간색, surfacechanged를 만들어 주라고 뜬다.

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        //surfaceView가 변경될때마다 호출되는 메서드
    }

    //여기까지해도 또 에러, destroyed를 만들어줘야함


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //surfaceView가 소멸될대 호출되는 메서드
        thread = null;
    }
    //Created,Changed,Destroyed는 callback때문에 구현한 것.
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //이미지를 객체화 해서 캔버스에 붙여 넣기

        Bitmap bitmap =
                BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        canvas.drawBitmap(bitmap,img_x,100,null);
    }
    public void setImg_x(int img_x){
        this.img_x = img_x;
    }
    public int getImg_x(){
        return img_x;
    }
}
