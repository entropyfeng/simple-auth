package com.github.entropyfeng.simpleauthinstance.domain.bo;

import java.util.Date;

/**
 * @author entropyfeng
 * @date 2019/12/30 21:05
 */
public class AuthUser {

    private int userId;

    private String username;

    private String password;

    private String phone;

    private String email;

    private int status;

    private String description;

    private Date createTime;

    private Date updateTime;

    //-----------------constructor-------------

    public AuthUser (String username ,String password){
        this.username=username;
        this.password=password;
    }


    //-----------------get and set--------------

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
