package com.github.entropyfeng.begauth.data.po;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 验证用户基础类
 *
 * @author entryfeng
 */
public  class BaseAuthUser {


    @NotNull
    private String userId;

    @NotNull
    private String password;

    /**
     * 密码加盐
     */
    private String salt;

    private String userStatus;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;


    //get and setter begin


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }


}
