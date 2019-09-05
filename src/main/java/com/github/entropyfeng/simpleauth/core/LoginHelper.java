package com.github.entropyfeng.simpleauth.core;

import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.data.AuthenticationToken;
import com.github.entropyfeng.simpleauth.util.HttpUtil;
import com.github.entropyfeng.simpleauth.util.JsonWebTokenUtil;
import com.github.entropyfeng.simpleauth.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author entropyfeng
 * @date 2019/7/11 21:48
 */
@Component
public class LoginHelper {



    private final RealmDispatcher realmDispatcher;

    private Logger logger=LoggerFactory.getLogger(LoginHelper.class);


    @Autowired
    public LoginHelper(RealmDispatcher realmDispatcher){
        this.realmDispatcher = realmDispatcher;
    }
    /**
     * 检查当前主体是否登录
     * @return false ->not login;true-> is login
     */
    public boolean isLogin(HttpServletRequest request){
       String authToken= HttpUtil.getAuthToken(request);

       String ip=HttpUtil.getIPAddress(request);
       if(!StringUtils.isEmpty(authToken)){
           try{
               JsonWebTokenUtil.parseJwt(authToken,AuthProperties.jwtSecretKey);
               logger.info("check ip->{} is login",ip);
               return true;
           }catch (Exception e){
               logger.info("check ip->{} not login but it's token incorrectly",ip);
           }
       }
        logger.info("check ip->{} not login",ip);
        return false;
    }
    public boolean tryLogin(AuthenticationToken authenticationToken){

       return realmDispatcher.dispatcher(authenticationToken);

    }

    public boolean tryLogout(){

        return false;
    }

    public boolean tryRenew(){
        return false;
    }
}
