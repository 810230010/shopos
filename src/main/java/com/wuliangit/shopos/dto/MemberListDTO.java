package com.wuliangit.shopos.dto;

import java.util.Date;

/**
 * Created by 26229 on 2017/5/5.
 */
public class MemberListDTO {

    private Integer memberId;

    private String nikename;

    private String sex;

    private Date birthday;

    private String type;

    private String mobile;

    private Integer points;

    private String authState;

    public MemberListDTO() {
    }

    public MemberListDTO(Integer memberId, String nikename, String sex, Date birthday, String type, String mobile, Integer points, String authState) {
        this.memberId = memberId;
        this.nikename = nikename;
        this.sex = sex;
        this.birthday = birthday;
        this.type = type;
        this.mobile = mobile;
        this.points = points;
        this.authState = authState;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getAuthState() {
        return authState;
    }

    public void setAuthState(String authState) {
        this.authState = authState;
    }
}
