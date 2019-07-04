package com.github.entropyfeng.simpleauth.data.to;

import com.github.entropyfeng.simpleauth.data.status.LoginStatus;

import java.security.acl.LastOwnerException;

/**
 * @author entropyfeng
 * @date 2019/7/2 16:53
 */
public class LoginDTO {

    private Long userId;

    private String password;

    private LoginStatus loginStatus;


    public LoginDTO(Long userId,String password){

        this.password=password;
        this.userId=userId;
        loginStatus=LoginStatus.DEFAULT;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LoginDTO{" + "userId=" + userId + ", password='" + password + '\'' + ", loginStatus=" + loginStatus + '}';
    }
}
