package com.github.entropyfeng.simpleauth.service.impl;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.exception.AccountNotExistException;
import com.github.entropyfeng.simpleauth.exception.PasswordErrorException;
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

    private final ApplicationEventPublisher eventPublisher;

    private final StringRedisTemplate redisTemplate;


    @Override
    public boolean checkPerm(@NotNull List<String> roleList, @NotNull String perm) {

        //在Redis中查询该角色集合是否包含相应权限
     return  roleList.stream().anyMatch(roleName-> redisTemplate.opsForSet().members(AuthProperties.AUTH_ROLE_SUFFIX+roleName).contains(perm));
    }

    @Override
    public String login(Long userId, String password)throws PasswordErrorException,AccountNotExistException {

  /*      LoginDTO loginDTO=new LoginDTO(userId,password);
        //发布一个登录事件
        eventPublisher.publishEvent(new LoginEvent(this,loginDTO));
        if(LoginStatus.SUCCESS.equals(loginDTO.getLoginStatus())){
            LoadRolesDTO loadRolesDTO=new LoadRolesDTO(userId);
            eventPublisher.publishEvent(new LoadUserRolesEvent(this,loadRolesDTO));
            return JsonWebTokenUtil.issueJWT(AuthProperties.jwtSecretKey,Long.toString(SnowFlakeUtil.getInstance().nextId()),Long.toString(userId),"server","web",60*60*24*7L, JSON.toJSONString(loadRolesDTO.getRoles()),"",SignatureAlgorithm.HS512);
        //密码错误
        }else if(LoginStatus.PASSWORD_ERROR.equals(loginDTO.getLoginStatus())){
            throw new PasswordErrorException();
        //账户不存在
        }else if(LoginStatus.ACCOUNT_NOT_EXIST.equals(loginDTO.getLoginStatus())){
            throw new AccountNotExistException();
        }*/


        return null;
    }


}
