package com.bytedance.tiktok.activity;

import com.bytedance.tiktok.R;
import com.bytedance.tiktok.common.CommonActivity;
import com.bytedance.tiktok.fragment.RecommendFragment;

//视频播放页
public class PlayListActivity extends CommonActivity {
    public static int pos;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_play_list;
    }

    @Override
    protected void myOnCreate() {
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, new RecommendFragment()).commit();
    }
}
