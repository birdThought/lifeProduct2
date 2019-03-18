package com.lifeshs.product.api.controller.pojo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {


    private String id;//ID


    private String mobile;//手机号码
    private String password;//密码
    private String username;//昵称
    private String sex;//性别
    private java.util.Date birthday;//出生年月日
    private String avatar;//头像
    private String email;//E-Mail
    private java.util.Date regdate;//注册日期
    private java.util.Date updatedate;//修改日期
    private java.util.Date lastdate;//最后登陆日期


    public User() {
    }

    public User(String id, String mobile, String password, String username, String sex, Date birthday, String avatar, String email, Date regdate, Date updatedate, Date lastdate) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.avatar = avatar;
        this.email = email;
        this.regdate = regdate;
        this.updatedate = updatedate;
        this.lastdate = lastdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
}