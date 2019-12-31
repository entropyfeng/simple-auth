package com.github.entropyfeng.simpleauth.event;


import com.github.entropyfeng.simpleauth.data.status.LoginStatus;
import com.github.entropyfeng.simpleauth.data.to.LoginDTO;
import org.springframework.context.ApplicationEvent;

/**
 * @author entropyfeng
 * @date 2019/6/28 21:10
 */
public class LoginEvent extends ApplicationEvent {

    private LoginDTO loginDTO;
    public LoginEvent(Object source, LoginDTO loginDTO) {
        super(source);
        this.loginDTO=loginDTO;
    }
    public Long getUserId(){
        return loginDTO.getUserId();
    }
    public String getPassword(){
        return loginDTO.getPassword();
    }

    public LoginStatus getLoginStatus(){
        return loginDTO.getLoginStatus();
    }
    public void setLoginStatus(LoginStatus loginStatus){
        loginDTO.setLoginStatus(loginStatus);
    }
}
