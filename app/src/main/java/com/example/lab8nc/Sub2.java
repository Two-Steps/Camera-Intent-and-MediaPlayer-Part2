package com.example.lab8nc;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Sub2 extends AppCompatActivity {
    TextView total_time, current_time;
    Button play, pause, stop;
    MediaPlayer mediaPlayer;
    int duration;
    int currentTime;
    String tt, cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        total_time = findViewById(R.id.total_time);
        current_time = findViewById(R.id.current_time);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);

        // sử dụng MediaPlayer
        mediaPlayer = MediaPlayer.create(Sub2.this, R.raw.sofaraway);

        duration = mediaPlayer.getDuration();
        currentTime = mediaPlayer.getCurrentPosition();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            tt = LocalTime.MIN.plusSeconds(duration).toString();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            cur = LocalTime.MIN.plusSeconds(currentTime).toString();
        }
        total_time.setText("Duration: " + tt);
        current_time.setText("Current: " + cur);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total_time.setText("Duration: " + tt);
                current_time.setText("Current: " + cur);
                mediaPlayer.start();
                Toast.makeText(Sub2.this, "Play", Toast.LENGTH_SHORT).show();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentTime = mediaPlayer.getCurrentPosition();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    cur = LocalTime.MIN.plusSeconds(currentTime).toString();
                }
                current_time.setText("Current: " + cur);
                mediaPlayer.pause();
                Toast.makeText(Sub2.this, "Pause", Toast.LENGTH_SHORT).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Toast.makeText(Sub2.this, "Stop", Toast.LENGTH_SHORT).show();
            }
        });
    }
}