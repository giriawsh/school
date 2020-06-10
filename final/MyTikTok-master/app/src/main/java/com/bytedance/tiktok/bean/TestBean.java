package com.bytedance.tiktok.bean;

import com.google.gson.annotations.SerializedName;

public class TestBean {
    @SerializedName("_id")
    private String id;
    @SerializedName("nickname")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("likecount")
    private int likecount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFeedurl() {
        return feedurl;
    }

    public void setFeedurl(String feedurl) {
        this.feedurl = feedurl;
    }

    @SerializedName("avatar")
    private String avatar;
    @SerializedName("feedurl")
    private String feedurl;

    @Override
    public String toString() {
        return "Tiktok{" +
                "id=" + id +
                ", feedurl='" + feedurl + '\'' +
                ", nickname=" + name + '\'' +
                ", description=" + description + '\'' +
                ", likecount = " + likecount + '\'' +
                ", avatar = " + avatar +
                '}';
    }//调试用
}
