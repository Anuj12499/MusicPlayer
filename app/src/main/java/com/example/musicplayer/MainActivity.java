package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    boolean flag=true;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.sorry);
        seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(fromUser)
                {
                    mediaPlayer.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

new Timer().scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
seekBar.setProgress(mediaPlayer.getCurrentPosition());
    }
}, 0,1000 );
    }
    public void decide(View view) {

 if(flag==true)
 {
     ImageView image=findViewById(R.id.imageView12);
     image.setImageResource(R.drawable.ic_pause_orange_24dp);
     mediaPlayer.start();
     flag=false;
 }
 else
 {
     ImageView image=findViewById(R.id.imageView12);
     image.setImageResource(R.drawable.ic_play_arrow_orange_24dp);
     mediaPlayer.pause();
     flag=true;
 }
    }

    public void goToStart(View view) {
        ImageView image=findViewById(R.id.imageView12);
        image.setImageResource(R.drawable.ic_play_arrow_orange_24dp);
        mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        flag=true;
    }

    public void goToEnd(View view) {
        ImageView image=findViewById(R.id.imageView12);
        image.setImageResource(R.drawable.ic_play_arrow_orange_24dp);
        seekBar.setProgress(mediaPlayer.getDuration());
        mediaPlayer.seekTo(seekBar.getProgress());
        mediaPlayer.pause();
        flag=true;

    }
}
