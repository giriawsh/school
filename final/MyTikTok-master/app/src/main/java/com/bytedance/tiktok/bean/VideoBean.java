package com.bytedance.tiktok.bean;

import com.google.gson.annotations.SerializedName;

//视频对象类
public class VideoBean {
    private String videoId;
    private int videoRes;
    private int coverRes;
    private String content;
    private UserBean userBean;
    private boolean isLiked;
    private int likeCount;
    private int commentCount;
    private int shareCount;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public int getVideoRes() {
        return videoRes;
    }

    public void setVideoRes(int videoRes) {
        this.videoRes = videoRes;
    }

    public int getCoverRes() {
        return coverRes;
    }

    public void setCoverRes(int coverRes) {
        this.coverRes = coverRes;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }


    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public static class UserBean {
        private String uid;
        private String nickName;
        private int head;
        private int likeCount;
        //用户类
        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getNickName() {
            return nickName == null ? "" : nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getHead() {
            return head;
        }

        public void setHead(int head) {
            this.head = head;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }
    }

}
