package com.github.entropyfeng.simpleauth.data.to;

/**
 * @author entropyfeng
 * @date 2019/7/2 16:53
 */
public class LoginDTO {

    private String userId;

    private String password;

    private String userStatus;

    public LoginDTO(String userId,String password){

        this.password=password;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "LoginDTO{" + "userId='" + userId + '\'' + ", password='" + password + '\'' + ", userStatus='" + userStatus + '\'' + '}';
    }
}
