package com.example.myapplication.clock;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.myapplication.clock.Clock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
public class ClockActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);

    }
}
