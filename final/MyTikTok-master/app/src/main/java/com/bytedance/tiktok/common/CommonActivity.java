package com.bytedance.tiktok.common;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.gyf.immersionbar.ImmersionBar;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//公共类
public abstract class CommonActivity extends AppCompatActivity {
    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());

        unbinder = ButterKnife.bind(this);
        myOnCreate();
    }

    protected abstract int setLayoutId();

    protected abstract void myOnCreate();
    //全屏设置
    protected void setFullScreen() {
        ImmersionBar.with(this).init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
