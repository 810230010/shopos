package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by 26229 on 2017/4/27.
 */
public class TuikeMemberDTO {

    private Integer memberId;

    private String nikename;

    private String sex;

    private String email;

    private Date createTime;

    private Integer points;

    public TuikeMemberDTO() {
    }

    public TuikeMemberDTO(Integer memberId, String nikename, String sex, String email, Date createTime, Integer points) {
        this.memberId = memberId;
        this.nikename = nikename;
        this.sex = sex;
        this.email = email;
        this.createTime = createTime;
        this.points = points;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
