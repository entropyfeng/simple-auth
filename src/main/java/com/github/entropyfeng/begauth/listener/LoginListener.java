package com.github.entropyfeng.begauth.listener;

import com.github.entropyfeng.begauth.event.LoginEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author entropyfeng
 * @date 2019/6/28 22:02
 */
@Component
public class LoginListener {

    @EventListener
    public void listener(LoginEvent loginEvent){

        try {
            Thread.sleep(10000);
            System.out.println("after wait***");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
