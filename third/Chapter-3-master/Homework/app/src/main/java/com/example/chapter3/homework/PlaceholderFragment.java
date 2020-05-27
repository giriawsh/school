package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;
import java.util.Objects;

public class PlaceholderFragment extends Fragment {
    static String[] dataList = {//Beijing University of Posts and Telecommunications
            "BEIJING",
            "UNIVERSITY",
            "OF",
            "POSTS",
            "AND",
            "TELECOMMUNICATIONS",
            "GIRIA"
    };
    ListView listView;
    LottieAnimationView animationView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = Objects.requireNonNull(getView()).findViewById(R.id.list_view);
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(Objects.requireNonNull(getActivity()),
                        android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(itemsAdapter);
        animationView = getView().findViewById(R.id.animation_view3);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                listView.setAlpha(0f);
                listView.setVisibility(View.VISIBLE);

                listView.animate()
                        .setDuration(1000)
                        .alpha(1.0f)
                        .setListener(null);

                animationView.animate()
                        .alpha(0f)
                        .setDuration(1000)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                animationView.setVisibility(View.GONE);
                            }
                        });
            }
        }, 5000);
    }
}
