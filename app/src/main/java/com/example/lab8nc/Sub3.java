package com.example.lab8nc;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Sub3 extends AppCompatActivity {
    TextView titleSong;
    ListView lv_song;
    FloatingActionButton fbtn_pause;
    MediaPlayer mediaPlayer = null;
    int id;

    // Sử dụng MediaPlayer để nghe một bài hát trong máy
    // Hoặc dùng cách sau để nghe nhạc online
    //String link = "https://data3.chiasenhac.com/downloads/1808/5/1807216-a82cf9d3/128/Six%20Feet%20Under%20-%20Billie%20Eilish.mp3";
    //MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, Uri.parse(link));
    //mediaPlayer.start();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syb3);
        titleSong = findViewById(R.id.titleSong);
        lv_song = findViewById(R.id.lv_song);
        fbtn_pause = findViewById(R.id.fbtn_pause);

        final String[] title = new String[]{"Breathless", "Counting star", "Cry on my shoulder", "So far away"};
        final int[] idSong = new int[]{R.raw.breathless, R.raw.countingstar, R.raw.cry, R.raw.sofaraway};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, title);
        lv_song.setAdapter(arrayAdapter);
        lv_song.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                titleSong.setText("Bài hát: " + title[i]);
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(titleSong, "translationX", 0f, 1400f);
                objectAnimator.setDuration(10000);
                objectAnimator.setRepeatCount(9);
                objectAnimator.start();

                id = i;
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    mediaPlayer = MediaPlayer.create(view.getContext(), idSong[i]);
                    mediaPlayer.start();
                } else {
                    mediaPlayer = MediaPlayer.create(view.getContext(), idSong[i]);
                    mediaPlayer.start();
                }
            }
        });

        fbtn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
    }
}