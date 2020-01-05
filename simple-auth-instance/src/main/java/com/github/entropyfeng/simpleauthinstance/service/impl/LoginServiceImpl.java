package com.github.entropyfeng.simpleauthinstance.service.impl;

import com.github.entropyfeng.simpleauthinstance.service.LoginService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;

/**
 * @author entropyfeng
 * @date 2020/1/5 16:28
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public String loginByUsernamePassword(@NotNull String username,@NotNull String password) {



        return null;
    }

    @Override
    public String loginByUsernamePasswordEncrypt(@NotNull String username, @NotNull String password) {


        return null;
    }
}
