package com.lifeshs.product.api.domain.po;

public class Doctor {
    private String id;
    private String userCode;
    private String userName;
    private String password;
    private String content;
    private String realName;
    private String mobile;
    private Long token;

    public Doctor() {
    }

    public Doctor(String userCode, String userName, String password, String content, String realName, String mobile, Long token,
                  String id) {
        this.userCode = userCode;
        this.userName = userName;
        this.password = password;
        this.content = content;
        this.realName = realName;
        this.mobile = mobile;
        this.token = token;
        this.id = id;
    }
    public String getId(){return id;}
    public void setId(String id){this.id = id; }
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getToken() {
        return token;
    }

    public void setToken(Long token) {
        this.token = token;
    }
}
