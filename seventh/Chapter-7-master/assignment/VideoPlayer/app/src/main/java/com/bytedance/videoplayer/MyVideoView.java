package com.bytedance.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.VideoView;
public class MyVideoView extends VideoView{

    public MyVideoView(Context context){
        super(context);
    }
    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private int myVideoWidth;
    private int myVideoHeight;

    public int getMyVideoHeight() {
        return myVideoHeight;
    }

    public void setMyVideoHeight(int myVideoHeight) {
        this.myVideoHeight = myVideoHeight;
    }

    public int getMyVideoWidth() {
        return myVideoWidth;
    }

    public void setMyVideoWidth(int myVideoWidth) {
        this.myVideoWidth = myVideoWidth;
    }

    @Override
    public void setVideoURI(Uri uri){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(this.getContext(), uri);
        myVideoWidth = Integer.parseInt(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH));
        myVideoHeight = Integer.parseInt(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT));
        super.setVideoURI(uri);
    }

    @Override
    protected void onMeasure(int widthMeasure, int heightMeasure){
        int width = getDefaultSize(myVideoHeight,widthMeasure);
        int height = getDefaultSize(myVideoHeight, heightMeasure);
        if(myVideoWidth > 0 && myVideoHeight > 0){
            if(myVideoWidth * height > myVideoHeight * width){
                height = width * myVideoHeight / myVideoWidth;//旋转扩展处理
            }else{
                width = height * myVideoWidth / myVideoHeight;//默认
            }
        }
        setMeasuredDimension(width, height);
    }

}
