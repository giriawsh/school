package com.bytedance.tiktok.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

//公共类
public abstract class CommonFragment extends Fragment {
    private View View;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.bind(this, View);

        myOnCreate();
        return View;
    }

    protected abstract int setLayoutId();

    protected abstract void myOnCreate();
}
