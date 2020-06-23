package com.example.mygameview;

        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.graphics.Rect;
        import android.os.Handler;
        import android.os.Message;
        import android.view.MotionEvent;
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
        //1.5초 후에 실행됨
        handler.sendEmptyMessageDelayed(0,DELAY);
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
            invalidate();

            String title = "stage - " + arShape.size();
            mParent.setTitle(title);
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
        //도형 모양 결정
        shape.what = rnd.nextInt(3);

        //도형 컬러
        switch(rnd.nextInt(5)){
            case 0:
                shape.color = Color.WHITE;
                break;
            case 1:
                shape.color = Color.RED;
                break;
            case 2:
                shape.color = Color.GREEN;
                break;
            case 3:
                shape.color = Color.BLUE;
                break;
            case 4:
                shape.color = Color.MAGENTA;
                break;
        }

        shape.rt = rt;
        arShape.add(shape);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //도형을 터치 했을때,
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            int sel;
            //도형의 위치를 제대로 클릭 했는지 판별하기 위한 메서드 호출

            sel = findShapeIdx((int)event.getX(),(int)event.getY());
            if(sel == -1){ //클릭이 안됐다.
                return true;
            }
            //마지막에 생성된 도형을 클릭했으면 다음 스테이지 넘기겠다.
            if (sel == arShape.size()-1){
                status = BLANK;
                invalidate();
                handler.sendEmptyMessageDelayed(0,DELAY);
            }else{
                //게임 종료시 alertDialog 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(mParent);
                builder.setMessage("restart Game??");
                builder.setTitle("Game Over");
                builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //게임 초기화
                        arShape.clear();
                        status = BLANK;
                        invalidate();
                        handler.sendEmptyMessageDelayed(0,DELAY);
                    }
                });

                builder.setPositiveButton("exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mParent.finish();//종료
                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        }

        return false;

    }

    public int findShapeIdx(int x, int y){
        for (int idx=0;idx<arShape.size();idx++){
            //arShape에 담긴 도형중에 터치된 x,y좌표를 가진 rect객체의 인덱스 값을 반환
            //contains : 있는지 없는지 찾기
            if(arShape.get(idx).rt.contains(x,y)){
                return idx;
            }
        }
        return -1;
    }
}
