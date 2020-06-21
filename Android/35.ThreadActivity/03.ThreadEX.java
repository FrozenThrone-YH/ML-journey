package com.example.mythreadactivity;

//우리가 사용할 Thread클래스 정의


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class ThreadEX extends Thread{

    //jandroid.os.Handler를 import해줘야한다.
    //쓰레드의 값등을 제어하는 클래스
    private Handler handler;
    private boolean check = true;

    //생성자
    public ThreadEX(Handler handler){
        this.handler = handler;
    }

    public void setCheck(boolean check){
        this.check = check;
        //run메서드에서 반복할때 check값이
        //true일때면 반복하도록 하고 false일때는 반복문을 탈출하여
        //쓰레드를 소멸되도록하기 위함
    }

    //쓰레드가 해야할일들을 정의한 메서드


    @Override
    public void run() {
        int value = 0;

        while(check){
            //왠만한 시스템 관련된 것은 try ~ catch 를 걸아야 한다.
            try{
                Thread.sleep(100); //내가 지정한 시간만큼 프로세스를 멈추는 메서드
            }catch(Exception e){
                e.printStackTrace();
            }
            Message msg = handler.obtainMessage();
            //메세지객체는 정보를 저장하는 객체
            //Bundle 객체로만 저장할 수 있다.

            Bundle bundle = new Bundle();

            bundle.putInt("value",value);

            msg.setData(bundle);

            //Handler에게 메세지정보를 전달받고록 한다.
            handler.sendMessage(msg);
            value++;

            //쓰레드를 실행하는 동안 msg가 메세지값을 받아서 그 메세지 안에다
            // value값을 계속 넣으면서 호출하겠다.


        }

        super.run();
    }
}
