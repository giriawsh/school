package com.bytedance.tiktok.activity;

import android.content.Intent;
import android.os.CountDownTimer;

import com.bytedance.tiktok.R;
import com.bytedance.tiktok.common.CommonActivity;

//启动页面
public class InitActivity extends CommonActivity {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_init;
    }

    @Override
    protected void myOnCreate() {
        setFullScreen();

        new CountDownTimer(800, 800) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(InitActivity.this, MainActivity.class));
                finish();
            }
        }.start();
    }
}
