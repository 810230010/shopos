package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by nilme on 2017/3/29.
 */
public class ApiCollectStoreDTO {

    private String name;

    private String logo;

    private String label;

    private Date favTime;

    public Date getFavTime() {
        return favTime;
    }

    public void setFavTime(Date favTime) {
        this.favTime = favTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
