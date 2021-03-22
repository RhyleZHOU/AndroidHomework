package com.example.myapplication.internet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.internet.model.Message;
import com.example.myapplication.internet.model.MessageListResponse;
import com.example.myapplication.internet.socket.SocketActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.example.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {
    private static final String TAG = "chapter5";
    private com.example.myapplication.internet.FeedAdapter adapter = new com.example.myapplication.internet.FeedAdapter();
    private int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        findViewById(R.id.btn_upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.myapplication.internet.MainActivity4.this, com.example.myapplication.internet.UploadActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_mine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(com.example.myapplication.internet.Constants.STUDENT_ID);
            }
        });

        findViewById(R.id.btn_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(null);
            }
        });
        findViewById(R.id.btn_socket).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.myapplication.internet.MainActivity4.this, SocketActivity.class);
                startActivity(intent);
            }
        });



    }

    //TODO 2
    // 用HttpUrlConnection实现获取留言列表数据，用Gson解析数据，更新UI（调用adapter.setData()方法）
    // 注意网络请求和UI更新分别应该放在哪个线程中
    private void getData(String studentId){
        new Thread((new Runnable() {
            @Override
            public void run() {
                MessageListResponse response = baseGetReposFromRemote(studentId, page, 10, "U0pUVS1ieXRlZGFuY2UtYW5kcm9pZA==");
                if (response != null && response.success == true && !response.feeds.isEmpty()) {
                    page++;
                    new Handler(getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.setData(response.feeds);
                        }
                    });
                }
            }
        })).start();
    }

    public MessageListResponse baseGetReposFromRemote(String studentId, int page, int perPage, String tocken){
        String urlStr = String.format("https://api-sjtu-camp-2021.bytedance.com/homework/invoke/messages", studentId, page, perPage);
        MessageListResponse result = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(6000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("tocken", tocken);
            if (conn.getResponseCode() == 200) {

                InputStream in = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));

                result = new Gson().fromJson(reader, MessageListResponse.class);

                reader.close();
                in.close();

            } else {
                // 错误处理
            }
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "网络异常" + e.toString(), Toast.LENGTH_SHORT).show();
        }
        return result;
    }


}