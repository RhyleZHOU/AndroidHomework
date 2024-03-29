package com.example.myapplication;

import com.example.myapplication.media.MainActivity6;
import com.example.myapplication.media2.MainActivity7;
import com.example.myapplication.search.SearchActivity;
import com.example.myapplication.animation.MainActivity2;
import com.example.myapplication.clock.SplashActivity;
import com.example.myapplication.internet.MainActivity4;
import com.example.myapplication.todolist.MainActivity5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    //private SearchAdapter mSearchAdapter = new SearchAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = findViewById(R.id.btn_w1);
        mButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        mButton2 = findViewById(R.id.btn_w2);
        mButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        mButton3 = findViewById(R.id.btn_w3);
        mButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        mButton4 = findViewById(R.id.btn_w4);
        mButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        mButton5 = findViewById(R.id.btn_w5);
        mButton5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(intent);
            }
        });

        mButton6 = findViewById(R.id.btn_w6);
        mButton6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity6.class);
                startActivity(intent);
            }
        });

        mButton7 = findViewById(R.id.btn_w7);
        mButton7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity7.class);
                startActivity(intent);
            }
        });
        
    }

}