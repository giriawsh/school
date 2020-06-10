package com.bytedance.tiktok.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bytedance.tiktok.R;
import com.bytedance.tiktok.common.CommonFragment;
import com.bytedance.tiktok.common.CommPagerAdapter;
import com.bytedance.tiktok.bean.PauseVideoEvent;
import com.bytedance.tiktok.utils.MyBus;
import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;

public class MainFragment extends CommonFragment {
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tab_title)
    XTabLayout tabTitle;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    static int curPage = 0;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void myOnCreate() {
        setFragments();
    }

    private void setFragments() {
        CurrentLocationFragment currentLocationFragment = new CurrentLocationFragment();
        RecommendFragment recommendFragment = new RecommendFragment();
        fragments.add(currentLocationFragment);
        fragments.add(recommendFragment);

        tabTitle.addTab(tabTitle.newTab().setText("义乌"));
        tabTitle.addTab(tabTitle.newTab().setText("推荐"));

        CommPagerAdapter pagerAdapter = new CommPagerAdapter(getChildFragmentManager(), fragments, new String[]{"义乌", "推荐"});
        viewPager.setAdapter(pagerAdapter);
        tabTitle.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabTitle.getTabAt(1)).select();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                curPage = position;

                if (position == 1) {
                    //继续播放
                    MyBus.getDefault().post(new PauseVideoEvent(true));
                } else {
                    //切换 视频暂停
                    MyBus.getDefault().post(new PauseVideoEvent(false));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
