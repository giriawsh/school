package com.bytedance.tiktok.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bytedance.tiktok.R;
import com.bytedance.tiktok.bean.VideoBean;
import com.bytedance.tiktok.utils.NumUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ControllerView extends RelativeLayout implements View.OnClickListener {
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.lottie_anim)
    LottieAnimationView animationView;
    @BindView(R.id.rl_like)
    RelativeLayout rlLike;
    @BindView(R.id.iv_comment)
    IconFontTextView ivComment;
    @BindView(R.id.iv_share)
    IconFontTextView ivShare;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.iv_like)
    IconFontTextView ivLike;
    @BindView(R.id.tv_likecount)
    TextView tvLikecount;
    @BindView(R.id.tv_commentcount)
    TextView tvCommentcount;
    @BindView(R.id.tv_sharecount)
    TextView tvSharecount;
    private OnVideoControllerListener listener;
    private VideoBean videoData;

    public ControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_controller, this);
        ButterKnife.bind(this, rootView);

        ivHead.setOnClickListener(this);
        ivComment.setOnClickListener(this);
        ivShare.setOnClickListener(this);
        rlLike.setOnClickListener(this);
    }

    public void setVideoData(VideoBean videoData) {
        this.videoData = videoData;
//        Glide.with(this).load("http://jzvd.nathen.cn/snapshot/f402a0e012b14d41ad07939746844c5e00005.jpg").into(ivHead);
        ivHead.setImageResource(videoData.getUserBean().getHead());
        tvNickname.setText("@" + videoData.getUserBean().getNickName());
        tvContent.setText(videoData.getContent());
        tvLikecount.setText(NumUtils.numberFilter(videoData.getLikeCount()));
        tvCommentcount.setText(NumUtils.numberFilter(videoData.getCommentCount()));
        tvSharecount.setText(NumUtils.numberFilter(videoData.getShareCount()));

        animationView.setAnimation("like.json");//lottie点赞动画

        //点赞状态
        if (videoData.isLiked()) {
            ivLike.setTextColor(getResources().getColor(R.color.color_red));
        } else {
            ivLike.setTextColor(getResources().getColor(R.color.white));
        }

    }

    public void setListener(OnVideoControllerListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener == null) {
            return;
        }

        switch (v.getId()) {
            case R.id.rl_like:
                listener.onLikeClick();

                like();
                break;
        }
    }

    public void like() {
        if (!videoData.isLiked()) {
            //点赞
            animationView.setVisibility(VISIBLE);
            animationView.playAnimation();
            ivLike.setTextColor(getResources().getColor(R.color.color_red));
        } else {
            //取消点赞
            animationView.setVisibility(INVISIBLE);
            ivLike.setTextColor(getResources().getColor(R.color.white));
        }

        videoData.setLiked(!videoData.isLiked());
    }

}
