package com.github.entropyfeng.simpleauth.listener;

import com.github.entropyfeng.simpleauth.data.UsernamePasswordEvent;
import com.github.entropyfeng.simpleauth.data.UsernamePasswordInfo;
import com.github.entropyfeng.simpleauth.data.status.PrincipalStatus;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author entropyfeng
 * @date 2019/7/11 21:21
 */
@Component
public class UsernamePasswordListener {


    @EventListener
    public void listener(UsernamePasswordEvent usernamePasswordEvent){

     String username= (String) usernamePasswordEvent.getAuthenticationToken().getCredential();

     String password=(String)usernamePasswordEvent.getAuthenticationToken().getPrincipal();

     usernamePasswordEvent.setAuthenticationInfo(new UsernamePasswordInfo("123","123",PrincipalStatus.PRINCIPAL_DISABLE));

    }

}
