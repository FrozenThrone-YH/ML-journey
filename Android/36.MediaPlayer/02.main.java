package com.example.mymacitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mplayer;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = (Switch)findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch1.isChecked()){
                    //스위치가 On이면 true이다. Off이면 false이다.
                    //file명 대문자 포함하면 안된다.
                    mplayer = MediaPlayer.create(MainActivity.this,R.raw.nonstop);
                    mplayer.start();
                }else{
                    mplayer.stop();
                }
            }
        });
    }
}
