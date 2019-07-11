package com.github.entropyfeng.simpleauth.data;


import com.github.entropyfeng.simpleauth.event.LoginEvent;

/**
 * @author entropyfeng
 * @date 2019/7/10 12:42
 */
public class UsernamePasswordEvent extends AbstractLoginEvent {

    public UsernamePasswordEvent(Object source, UsernamePasswordToken authenticationToken, UsernamePasswordInfo usernamePasswordInfo) {
        super(source, authenticationToken, usernamePasswordInfo);


    }

}
