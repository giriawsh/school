package com.bytedance.tiktok.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.tiktok.R;
import com.bytedance.tiktok.utils.AnimUtils;
import java.util.Random;

public class LikeView extends RelativeLayout {
    private GestureDetector gestureDetector;
    private OnPlayPauseListener onPlayPauseListener;
    private OnLikeListener onLikeListener;

    public LikeView(Context context) {
        super(context);
        init();
    }

    public LikeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                addLikeView(e);
                onLikeListener.onLikeListener();
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                if (onPlayPauseListener != null) {
                    onPlayPauseListener.onPlayOrPause();
                }
                return true;
            }
        });

        setOnTouchListener((v, event) -> {
            gestureDetector.onTouchEvent(event);
            return true;
        });
    }

    private void addLikeView(MotionEvent e) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.mipmap.ic_like);

        addView(imageView);

        int likeViewSize = 330;
        RelativeLayout.LayoutParams layoutParams = new LayoutParams(likeViewSize, likeViewSize);
        layoutParams.leftMargin = (int) e.getX() - likeViewSize / 2;
        layoutParams.topMargin = (int) e.getY() - likeViewSize;
        imageView.setLayoutParams(layoutParams);

        playAnim(imageView);
    }

    private void playAnim(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(AnimUtils.scaleAnim(100, 2f, 1f, 0));
        animationSet.addAnimation(AnimUtils.alphaAnim(0, 1, 100, 0));
        animationSet.addAnimation(AnimUtils.scaleAnim(500, 1f, 1.8f, 300));
        animationSet.addAnimation(AnimUtils.alphaAnim(1f, 0, 500, 300));
        animationSet.addAnimation(AnimUtils.translationAnim(500, 0, 0, 0, -400, 300));

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().post(() -> removeView(view));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(animationSet);
    }

    public interface OnPlayPauseListener {
        void onPlayOrPause();
    }

    public void setOnPlayPauseListener(OnPlayPauseListener onPlayPauseListener) {
        this.onPlayPauseListener = onPlayPauseListener;
    }

    public interface OnLikeListener {
        void onLikeListener();
    }

    //双击点赞
    public void setOnLikeListener(OnLikeListener onLikeListener) {
        this.onLikeListener = onLikeListener;
    }
}
