package com.github.entropyfeng.simpleauthinstance.service.impl;

import com.github.entropyfeng.simpleauth.service.IDService;
import com.github.entropyfeng.simpleauthinstance.domain.bo.AuthUser;
import com.github.entropyfeng.simpleauthinstance.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:41
 */
@Service
public class RegisterServiceImpl implements RegisterService {



    private final IDService idService;

    @Autowired
    public RegisterServiceImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") IDService idService) {
        this.idService = idService;
    }

    @Override
    public boolean registerByUsernamePassword(@NotNull String username, @NotNull String password) {


        AuthUser authuser = new AuthUser(username, password);

        int userId = idService.getGlobalUniqueId();

        authuser.setUserId(userId);


        return false;
    }
}
