package com.github.entropyfeng.simpleauth.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.data.status.LoginStatus;
import com.github.entropyfeng.simpleauth.data.to.LoadRolesDTO;
import com.github.entropyfeng.simpleauth.data.to.LoginDTO;
import com.github.entropyfeng.simpleauth.event.LoadUserRolesEvent;
import com.github.entropyfeng.simpleauth.event.LoginEvent;
import com.github.entropyfeng.simpleauth.service.AuthService;
import com.github.entropyfeng.simpleauth.util.JsonWebTokenUtil;
import com.github.entropyfeng.simpleauth.util.SnowFlakeUtil;
import io.jsonwebtoken.SignatureAlgorithm;
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
    public String login(Long userId, String password) {

        LoginDTO loginDTO=new LoginDTO(userId,password);
        //发布一个登录事件
        eventPublisher.publishEvent(new LoginEvent(this,loginDTO));
        if(LoginStatus.SUCCESS.equals(loginDTO.getLoginStatus())){
            LoadRolesDTO loadRolesDTO=new LoadRolesDTO(userId);
            eventPublisher.publishEvent(new LoadUserRolesEvent(this,loadRolesDTO));
            return JsonWebTokenUtil.issueJWT(AuthProperties.jwtSecretKey,Long.toString(SnowFlakeUtil.getInstance().nextId()),Long.toString(userId),"server","web",60*60*24*7L, JSON.toJSONString(loadRolesDTO.getRoles()),"",SignatureAlgorithm.HS512);
        }

        return null;
    }
}
