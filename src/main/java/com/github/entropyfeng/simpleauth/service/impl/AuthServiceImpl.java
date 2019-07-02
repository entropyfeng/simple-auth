package com.github.entropyfeng.simpleauth.service.impl;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.data.to.StringHolder;
import com.github.entropyfeng.simpleauth.event.LoginEvent;
import com.github.entropyfeng.simpleauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author entropyfeng
 * @date 2019/6/17 21:32
 */
@Service
public class AuthServiceImpl implements AuthService {



    @Autowired
    public AuthServiceImpl(ApplicationEventPublisher eventPublisher, StringRedisTemplate redisTemplate) {
        this.eventPublisher = eventPublisher;
        this.redisTemplate = redisTemplate;
    }

    private ApplicationEventPublisher eventPublisher;

    private StringRedisTemplate redisTemplate;


    @Override
    public boolean checkPerm(@NotNull List<String> roleList, @NotNull String perm) {

     return  roleList.stream().anyMatch(roleName-> redisTemplate.opsForSet().members(AuthProperties.authRoleSuffix+roleName).contains(perm));

    }

    @Override
    public String login(String userId, String password) {
        StringHolder holder=new StringHolder();
        //发布一个登录事件
        eventPublisher.publishEvent(new LoginEvent(this,userId,password, holder));

        System.out.println("after publish" +holder.getValue());


        return null;
    }
}
