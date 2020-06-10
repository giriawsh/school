package com.bytedance.tiktok.common;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

//公共类
public class CommonViewHolder extends RecyclerView.ViewHolder {
    public CommonViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
