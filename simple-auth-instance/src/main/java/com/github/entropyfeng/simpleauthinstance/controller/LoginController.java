package com.github.entropyfeng.simpleauthinstance.controller;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.simpleauth.config.anno.PostAuth;
import com.github.entropyfeng.simpleauth.data.vo.Message;
import com.github.entropyfeng.simpleauth.exception.AccountNotExistException;
import com.github.entropyfeng.simpleauth.exception.PasswordErrorException;
import com.github.entropyfeng.simpleauthinstance.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author entropyfeng
 * @date 2020/1/5 16:11
 */
@RestController
public class LoginController {

    private static final Logger logger=LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login/up")
    public String login(@RequestParam("username")String username,@RequestParam("password") String password ){

        Message message=new Message();
        logger.info("username -> {} ; password->{}",username,password);

        String token=null;
        try {
            token= loginService.loginByUsernamePassword(username,password);
        }catch (PasswordErrorException e){

            logger.info("[password error] username->{}",username);
        }catch (AccountNotExistException e){
            logger.info("[account not exists] username->",username);
        }
        if(token==null){
            message.setSuccess(false);
            message.setMsg("用户名密码不匹配！");
        }else {
            message.setSuccess(true);
        }

        return JSON.toJSONString(message);
    }

    @PostMapping("/testPost")
    @PostAuth("/testPost")
    public String testPost(){

        return null;
    }

}
