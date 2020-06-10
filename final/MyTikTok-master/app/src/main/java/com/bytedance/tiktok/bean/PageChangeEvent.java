package com.bytedance.tiktok.bean;

//翻页事件
public class PageChangeEvent {
    private int page;
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public PageChangeEvent(int page) {
        this.page = page;
    }
}
