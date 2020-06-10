package com.bytedance.tiktok.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.bytedance.tiktok.R;
import com.bytedance.tiktok.activity.PlayListActivity;
import com.bytedance.tiktok.common.CommonAdapter;
import com.bytedance.tiktok.common.CommonViewHolder;
import com.bytedance.tiktok.bean.VideoBean;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

//列表页
public class VideoListAdapter extends CommonAdapter<VideoBean, VideoListAdapter.VideoListViewHolder> {

    public VideoListAdapter(Context context, List<VideoBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(VideoListViewHolder holder, VideoBean videoBean, int position) {
        holder.ivCover.setBackgroundResource(videoBean.getCoverRes());
        holder.tvContent.setText(videoBean.getContent());
//        Glide.with()
        holder.ivHead.setImageResource(videoBean.getUserBean().getHead());

        holder.itemView.setOnClickListener(v -> {
            PlayListActivity.pos = position;
            context.startActivity(new Intent(context, PlayListActivity.class));
        });
    }

    @NonNull
    @Override
    public VideoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gridvideo, parent, false);
        return new VideoListViewHolder(view);
    }

    static class VideoListViewHolder extends CommonViewHolder {
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.iv_head)
        ImageView ivHead;

        VideoListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
