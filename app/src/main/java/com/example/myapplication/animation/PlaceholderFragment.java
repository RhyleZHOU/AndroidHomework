package com.example.myapplication.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
public class PlaceholderFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(R.id.animation_loading,
                        "alpha", 1, 0);
                animator1.setRepeatCount(1);
                animator1.setInterpolator(new LinearInterpolator());
                animator1.setDuration(2000);
                animator1.start();

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(R.id.list_names,
                        "alpha", 0, 1);
                animator2.setRepeatCount(1);
                animator2.setInterpolator(new LinearInterpolator());
                animator2.setDuration(2000);
                animator2.start();


            }
        }, 2000);
    }
}
