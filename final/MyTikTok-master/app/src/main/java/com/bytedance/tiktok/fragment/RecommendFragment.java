package com.bytedance.tiktok.fragment;

import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.tiktok.R;
import com.bytedance.tiktok.activity.MainActivity;
import com.bytedance.tiktok.activity.PlayListActivity;
import com.bytedance.tiktok.adapter.VideoAdapter;
import com.bytedance.tiktok.common.CommonFragment;
import com.bytedance.tiktok.bean.MyData;
import com.bytedance.tiktok.bean.PauseVideoEvent;
import com.bytedance.tiktok.view.OnVideoControllerListener;
import com.bytedance.tiktok.utils.MyBus;
import com.bytedance.tiktok.view.ControllerView;
import com.bytedance.tiktok.view.FullScreenVideoView;
import com.bytedance.tiktok.view.LikeView;
import com.bytedance.tiktok.view.pagermanager.OnViewPagerListener;
import com.bytedance.tiktok.view.pagermanager.PagerManager;
import butterknife.BindView;
import rx.functions.Action1;

public class RecommendFragment extends CommonFragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private PagerManager pagerManager;
    private int curPlayPos = -1;
    private FullScreenVideoView videoView;
    private ImageView ivCurCover;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void myOnCreate() {

        VideoAdapter adapter = new VideoAdapter(getActivity(), MyData.datas);
        recyclerView.setAdapter(adapter);

        videoView = new FullScreenVideoView(getActivity());

        PagerManager();

        MyBus.getDefault()
                .toObservable(PauseVideoEvent.class)
                .subscribe((Action1<PauseVideoEvent>) event -> {
                if (!event.isPlayOrPause()) {
                    videoView.pause();
                } else {
                    videoView.start();
                }
            });

    }

    @Override
    public void onPause() {
        super.onPause();

        videoView.pause();
    }

    @Override
    public void onStop() {
        super.onStop();

        videoView.stopPlayback();
    }

    private void PagerManager() {
        pagerManager = new PagerManager(getActivity());
        recyclerView.setLayoutManager(pagerManager);
        recyclerView.scrollToPosition(PlayListActivity.pos);

        pagerManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onPageRelease(boolean isNext, int position) {
                if (ivCurCover != null) {
                    ivCurCover.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onInitComplete() {
                playCurVideo(PlayListActivity.pos);
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {
                playCurVideo(position);
            }
        });
    }


    private void playCurVideo(int position) {
        if (position == curPlayPos) {
            return;
        }

        View itemView = pagerManager.findViewByPosition(position);
        if (itemView == null) {
            return;
        }

        ViewGroup rootView = itemView.findViewById(R.id.rl_container);
        LikeView likeView = rootView.findViewById(R.id.likeview);
        ControllerView controllerView = rootView.findViewById(R.id.controller);
        ImageView ivPlay = rootView.findViewById(R.id.iv_play);
        ImageView ivCover = rootView.findViewById(R.id.iv_cover);
        ivPlay.setAlpha(0.4f);

        //播放暂停事件
        likeView.setOnPlayPauseListener(() -> {
            if (videoView.isPlaying()) {
                videoView.pause();
                ivPlay.setVisibility(View.VISIBLE);
            } else {
                videoView.start();
                ivPlay.setVisibility(View.GONE);
            }
        });

        //评论点赞事件
        likeShareEvent(controllerView);

        curPlayPos = position;

        dettachParentView(rootView);

        autoPlayVideo(curPlayPos, ivCover);
    }

    private void dettachParentView(ViewGroup rootView) {
        ViewGroup parent = (ViewGroup) videoView.getParent();
        if (parent != null) {
            parent.removeView(videoView);
        }
        rootView.addView(videoView, 0);
    }

    private void autoPlayVideo(int position, ImageView ivCover) {
        String bgVideoPath = "android.resource://" + getActivity().getPackageName() + "/" + MyData.datas.get(position).getVideoRes();
        videoView.setVideoPath(bgVideoPath);
//        String s = "http://jzvd.nathen.cn/video/1137e480-170bac9c523-0007-1823-c86-de200.mp4";
//        videoView.setVideoURI(Uri.parse(s));
        videoView.start();
        videoView.setOnPreparedListener(mp -> {
            mp.setLooping(true);

            new CountDownTimer(200, 200) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    ivCover.setVisibility(View.GONE);
                    ivCurCover = ivCover;
                }
            }.start();
        });
    }

    //点赞等事件
    private void likeShareEvent(ControllerView controllerView) {
        controllerView.setListener(new OnVideoControllerListener() {
            @Override
            public void onLikeClick() {

            }
        });
    }

}
