package com.example.myapplication.media;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity6 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        initButton();
    }

    private void initButton() {
        open(R.id.permission, PermissionActivity.class);
        open(R.id.image, ImageActivity.class);
        open(R.id.frescoImage, FrescoImageActivity.class);
        open(R.id.videoView, VideoActivity.class);
        open(R.id.canvas, CanvasActivity.class);
        open(R.id.mediaPlayer, MediaPlayerActivity.class);
        open(R.id.glideImage, GlideActivity.class);
    }

    private void open(int buttonId, final Class<?> clz) {
        findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity6.this, clz));
            }
        });
    }



}
