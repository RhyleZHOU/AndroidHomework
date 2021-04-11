package com.example.myapplication.media;

import android.graphics.PixelFormat;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class VideoActivity extends AppCompatActivity {
    private Button buttonPlay;
    private Button buttonPause;
    private VideoView videoView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video);

        buttonPause = findViewById(R.id.buttonPause);
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
            }
        });

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });

        videoView = findViewById(R.id.videoView);
        videoView.getHolder().setFormat(PixelFormat.TRANSPARENT);
        videoView.setZOrderOnTop(true);
        videoView.setVideoPath(getVideoPath(R.raw.big_buck_bunny));

    }


    private String getVideoPath(int resId) {
        return "android.resource://" + this.getPackageName() + "/" + resId;
    }
}
