package com.wuliangit.shopos.dto;

import java.io.Serializable;

/**
 * Created by wuliang01 on 2017/7/1.
 */
public class LoadingPicDTO {

    private Integer id;

    private String img;

    private Boolean open;

    public LoadingPicDTO() {
    }

    public LoadingPicDTO(Integer id, String img, Boolean open) {
        this.id = id;
        this.img = img;
        this.open = open;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
