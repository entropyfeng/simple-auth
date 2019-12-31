package com.github.entropyfeng.myauth.core.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.github.entropyfeng.myauth.config.AuthProperties;
import com.github.entropyfeng.myauth.config.anno.*;
import com.github.entropyfeng.myauth.data.vo.Message;
import com.github.entropyfeng.myauth.util.HttpUtil;
import com.github.entropyfeng.myauth.util.JsonWebTokenUtil;
import com.github.entropyfeng.myauth.util.JwtAccount;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

/**
 * each controller only support one Annotation , and its privilege level as follows
 * get>post>put>delete>patch
 *
 * @author entropyfeng
 */
public class AuthTokenInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenInterceptor.class);



    @Autowired
    AuthService authService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {


        boolean res = true;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String perm=handleMethod(handlerMethod);
            if(perm!=null){
             res= checkAuth(perm,request,response);
            }
        }

        return res;
    }

    private String handleMethod(HandlerMethod handlerMethod) {

        Annotation[] annotations = handlerMethod.getMethod().getAnnotations();
        boolean isGet = Arrays.stream(annotations).anyMatch(annotation -> GetAuth.class.getName().equals(annotation.annotationType().getName()));
        if (isGet) {
         return "GET"+AuthProperties.RESOURCE_METHOD_JOINT+handlerMethod.getMethodAnnotation(GetAuth.class).value();
        }
        boolean isPost = Arrays.stream(annotations).anyMatch(annotation -> PostAuth.class.getName().equals(annotation.annotationType().getName()));

        if (isPost) {
            return "POST"+AuthProperties.RESOURCE_METHOD_JOINT+handlerMethod.getMethodAnnotation(PostAuth.class);
        }
        boolean isPut = Arrays.stream(annotations).anyMatch(annotation -> PutAuth.class.getName().equals(annotation.annotationType().getName()));

        if (isPut) {
            return "PUT"+AuthProperties.RESOURCE_METHOD_JOINT+handlerMethod.getMethodAnnotation(PutAuth.class);
        }
        boolean isDelete = Arrays.stream(annotations).anyMatch(annotation -> DeleteAuth.class.getName().equals(annotation.annotationType().getName()));
        if (isDelete) {
            return "DELETE"+AuthProperties.RESOURCE_METHOD_JOINT+handlerMethod.getMethodAnnotation(DeleteAuth.class);
        }

        boolean isPatch = Arrays.stream(annotations).anyMatch(annotation -> PatchAuth.class.getName().equals(annotation.annotationType().getName()));

        if (isPatch) {
            return "PATCH"+AuthProperties.RESOURCE_METHOD_JOINT+handlerMethod.getMethodAnnotation(PatchAuth.class);
        }
        //如果不匹配以上任何一个，则说明该方法不是此interceptor所要拦截的.
        return null;
    }



    private boolean checkAuth(String perm, HttpServletRequest request, HttpServletResponse response) {

        boolean res = false;
        JwtAccount jwtAccount = parseRequest(request, response);
        if (jwtAccount != null) {
            List<String> roleList = null;
            try {
                roleList = JSON.parseArray(jwtAccount.getRoles(), String.class);
            } catch (JSONException e) {
                logger.info("parse roleList error");
            }

            if (roleList != null) {
                if (!authService.checkPerm(roleList, perm)) {
                    Message message = new Message();
                    message.setSuccess(false);
                    message.setMsg("auth error");
                    HttpUtil.writeJsonResponse(response, JSON.toJSONString(message));
                } else {
                    res = true;
                }
            }

        }
        return res;
    }

    private JwtAccount parseRequest(HttpServletRequest request, HttpServletResponse response) {

        String authToken = (String) request.getAttribute(AuthProperties.authTokenName);
        if (StringUtils.isEmpty(authToken)) {
            authToken = request.getParameter(AuthProperties.authTokenName);
        }
        Message message = new Message();
        JwtAccount jwtAccount = null;
        if (!StringUtils.isEmpty(authToken)) {
            try {
                jwtAccount = JsonWebTokenUtil.parseJwt(authToken, AuthProperties.jwtSecretKey);
            } catch (ExpiredJwtException e) {
                logger.info("token {} expired", authToken, e.getMessage());
                message.setSuccess(false);
                message.setMsg("token expired");

            } catch (SignatureException e) {
                logger.info("token {} signature check fail", authToken, e.getMessage());
                message.setSuccess(false);
                message.setMsg("signature check fail");

            } catch (Exception e) {
                logger.info("token {} illegal", authToken, e.getMessage());
                message.setSuccess(false);
                message.setMsg("token illegal");
            }

        } else {
            message.setSuccess(false);
            message.setMsg("required " + AuthProperties.authTokenName);

        }

        if (jwtAccount == null) {
            HttpUtil.writeJsonResponse(response, JSON.toJSONString(message));
        }


        return jwtAccount;
    }



}
