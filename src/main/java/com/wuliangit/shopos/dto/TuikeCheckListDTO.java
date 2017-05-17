package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by 26229 on 2017/4/27.
 */
public class TuikeCheckListDTO {

    private Integer memberId;

    private String nickname;

    private String sex;

    private String email;

    private Date createTime;

    private Integer points;

    public TuikeCheckListDTO() {
    }

    public TuikeCheckListDTO(Integer memberId, String nickname, String sex, String email, Date createTime, Integer points) {
        this.memberId = memberId;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
