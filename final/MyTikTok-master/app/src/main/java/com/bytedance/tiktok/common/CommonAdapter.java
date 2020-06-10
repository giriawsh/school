package com.bytedance.tiktok.common;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//公共类
public abstract class CommonAdapter<T,VH extends CommonViewHolder> extends RecyclerView.Adapter<VH> {
    protected Context context;
    protected List<T> mDatas;
    protected OnItemClickListener onItemClickListener;
    public CommonAdapter(Context context, List<T> datas) {
        this.context = context;
        mDatas = datas;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(v -> {
                onItemClickListener.onItemClick(v, position);
            });
        }
        onBindData(holder,mDatas.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    protected abstract void onBindData(VH holder, T data, int position);

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

}
