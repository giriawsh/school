package com.bytedance.tiktok.fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bytedance.tiktok.R;
import com.bytedance.tiktok.adapter.VideoListAdapter;
import com.bytedance.tiktok.common.CommonFragment;
import com.bytedance.tiktok.bean.MyData;

import butterknife.BindView;
public class CurrentLocationFragment extends CommonFragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private VideoListAdapter adapter;


    @Override
    protected int setLayoutId() {
        return R.layout.fragment_current_location;
    }

    @Override
    protected void myOnCreate() {
        new MyData().initData();
        
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        adapter = new VideoListAdapter(getActivity(), MyData.datas);
        recyclerView.setAdapter(adapter);

    }

}
