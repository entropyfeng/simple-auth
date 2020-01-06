package com.github.entropyfeng.simpleauthinstance.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.exception.AccountNotExistException;
import com.github.entropyfeng.simpleauth.exception.PasswordErrorException;
import com.github.entropyfeng.simpleauth.util.JsonWebTokenUtil;
import com.github.entropyfeng.simpleauth.util.SecurityUtil;
import com.github.entropyfeng.simpleauthinstance.dao.AuthUserMapper;
import com.github.entropyfeng.simpleauthinstance.domain.bo.AuthUser;
import com.github.entropyfeng.simpleauthinstance.service.LoginService;
import io.jsonwebtoken.SignatureAlgorithm;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.UUID;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:28
 */
@Service
public class LoginServiceImpl implements LoginService {


    private final AuthUserMapper authUserMapper;

    @Autowired
    public LoginServiceImpl(AuthUserMapper authUserMapper) {
        this.authUserMapper = authUserMapper;
    }

    @Override
    public String loginByUsernamePassword(@NotNull String username,@NotNull String password)throws AccountNotExistException,PasswordErrorException {


       String afterAddSalt= SecurityUtil.addSalt(password,AuthProperties.SALT);
       String dbPassword=  authUserMapper.selectPasswordByUsername(username);



       if(StringUtils.isEmpty(dbPassword)){
           throw new AccountNotExistException();
       }
       if(!afterAddSalt.equals(dbPassword)){
           throw new PasswordErrorException();
       }

       AuthUser authUser= authUserMapper.selectAuthUserByUsername(username);
       String roles= JSON.toJSONString(authUserMapper.selectRolesByUid(authUser.getUserId()));

       //密码账户匹配，签发token
        return JsonWebTokenUtil.issueJWT(AuthProperties.JWT_SECRET_KEY, UUID.randomUUID().toString(),String.valueOf(authUser.getUserId()),"default server","",(long)24*60*60*1000,roles,"",SignatureAlgorithm.RS512);
    }

    @Override
    public String loginByUsernamePasswordEncrypt(@NotNull String username, @NotNull String password) {

        return null;
    }
}
