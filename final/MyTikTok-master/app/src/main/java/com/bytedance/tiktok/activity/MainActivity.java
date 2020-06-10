package com.bytedance.tiktok.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.tiktok.R;
import com.bytedance.tiktok.common.CommonActivity;
import com.bytedance.tiktok.common.CommPagerAdapter;
import com.bytedance.tiktok.bean.PauseVideoEvent;
import com.bytedance.tiktok.fragment.MainFragment;
import com.bytedance.tiktok.utils.MyBus;
import java.util.ArrayList;
import butterknife.BindView;

//主页面
public class MainActivity extends CommonActivity {
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private MainFragment mainFragment = new MainFragment();
    public static int curPage;//当前页面


    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void myOnCreate() {

        fragments.add(mainFragment);
        CommPagerAdapter pagerAdapter = new CommPagerAdapter(getSupportFragmentManager(), fragments, new String[]{"", ""});
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                curPage = position;

                if (position == 1) {
                    MyBus.getDefault().post(new PauseVideoEvent(false));
                } else if (position == 0){
                    MyBus.getDefault().post(new PauseVideoEvent(true));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
