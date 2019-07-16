package com.github.entropyfeng.simpleauth.listener;

import com.github.entropyfeng.simpleauth.data.UsernamePasswordInfo;
import com.github.entropyfeng.simpleauth.data.UsernamePasswordRealm;
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
    public void listener(UsernamePasswordRealm realm){

        String username= (String) realm.getUsernamePasswordToken().getPrincipal();
        realm.setUsernamePasswordInfo(new UsernamePasswordInfo("123","456",PrincipalStatus.SUCCESS));

    }

}
