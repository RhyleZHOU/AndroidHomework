package com.example.myapplication.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.example.myapplication.search.SearchActivity;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.example.myapplication.R;
import com.example.myapplication.search.SearchAdapter;
import com.example.myapplication.search.SearchLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlaceholderFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private SearchAdapter mSearchAdapter = new SearchAdapter();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View v = inflater.inflate(R.layout.fragment_placeholder, container, false);
        mRecyclerView = v.findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mSearchAdapter);
        final List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add("这是第 " + i + " 行");
        }
        mSearchAdapter.notifyItems(items);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                View v1 = getView().findViewById(R.id.animation_loading);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(v1,
                        "alpha", 1, 0);
                animator1.setInterpolator(new LinearInterpolator());
                animator1.setDuration(500);
                animator1.start();

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(mRecyclerView,
                        "alpha", 0, 1);
                animator2.setInterpolator(new LinearInterpolator());
                animator2.setDuration(500);
                animator2.start();

                mRecyclerView.setVisibility(View.VISIBLE);
                v1.setVisibility(View.INVISIBLE);

            }
        }, 5000);
    }
}
