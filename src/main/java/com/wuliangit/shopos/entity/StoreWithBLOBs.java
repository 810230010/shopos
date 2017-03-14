package com.wuliangit.shopos.entity;

public class StoreWithBLOBs extends Store {
    private String slide;

    private String slideUrl;

    public String getSlide() {
        return slide;
    }

    public void setSlide(String slide) {
        this.slide = slide == null ? null : slide.trim();
    }

    public String getSlideUrl() {
        return slideUrl;
    }

    public void setSlideUrl(String slideUrl) {
        this.slideUrl = slideUrl == null ? null : slideUrl.trim();
    }
}