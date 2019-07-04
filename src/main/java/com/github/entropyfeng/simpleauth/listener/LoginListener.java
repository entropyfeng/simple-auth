package com.github.entropyfeng.simpleauth.listener;

import com.github.entropyfeng.simpleauth.event.LoginEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author entropyfeng
 * @date 2019/6/28 22:02
 */
@Component
public class LoginListener {


    @Order(0)
    @EventListener
    public void listener(LoginEvent loginEvent){

        System.out.println("0 before wait***");
        try {
            Thread.sleep(1000);
            System.out.println("0 after wait***");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
