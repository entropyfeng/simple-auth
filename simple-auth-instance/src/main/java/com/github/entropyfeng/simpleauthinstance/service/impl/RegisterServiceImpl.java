package com.github.entropyfeng.simpleauthinstance.service.impl;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.service.IDService;
import com.github.entropyfeng.simpleauth.util.SecurityUtil;
import com.github.entropyfeng.simpleauthinstance.dao.AuthUserMapper;
import com.github.entropyfeng.simpleauthinstance.domain.bo.AuthUser;
import com.github.entropyfeng.simpleauthinstance.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:41
 */
@Service
public class RegisterServiceImpl implements RegisterService {



    private static final Logger logger=LoggerFactory.getLogger(RegisterServiceImpl.class);
    private final IDService idService;


    private final AuthUserMapper authUserMapper;
    @Autowired
    public RegisterServiceImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") IDService idService,AuthUserMapper authUserMapper) {
        this.idService = idService;
        this.authUserMapper=authUserMapper;
    }

    @Override
    public boolean registerByUsernamePassword(@NotNull String username, @NotNull String password) {



        AuthUser authuser = new AuthUser(username,  SecurityUtil.addSalt(password,AuthProperties.SALT));
        int userId = idService.getGlobalUniqueId();
        authuser.setUserId(userId);
        try {

            authUserMapper.insertAuthUser(authuser);
            //最可能是username冲突,也可能是userId冲突
        }catch (DuplicateKeyException e){

            logger.info("[username or primary key duplicate] username={} and userId={} ",username,userId);
            logger.info(e.getMessage());
            logger.info("[discard primary key] :{}",userId);
        }




        return false;
    }

    @Override
    public boolean checkDuplicateUsername(@NotNull String username) {

        return 0==authUserMapper.selectCountUsername(username);
    }

    @Override
    public boolean checkDuplicatePhone(@NotNull String phone) {

        return 0==authUserMapper.selectCountPhone(phone);
    }

    @Override
    public boolean checkDuplicateEmail(@NotNull String email) {

        return 0==authUserMapper.selectCountEmail(email);
    }
}
