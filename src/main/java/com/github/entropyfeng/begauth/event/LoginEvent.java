package com.github.entropyfeng.begauth.event;


import com.github.entropyfeng.begauth.data.to.StringHolder;
import org.springframework.context.ApplicationEvent;

/**
 * @author entropyfeng
 * @date 2019/6/28 21:10
 */
public class LoginEvent extends ApplicationEvent {
    public LoginEvent(Object source, String userId, String password, StringHolder res) {

        super(source);

        res.setValue("success");
    }
}
