package com.github.entropyfeng.simpleauth.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.config.anno.*;
import com.github.entropyfeng.simpleauth.data.vo.Message;
import com.github.entropyfeng.simpleauth.service.AuthService;
import com.github.entropyfeng.simpleauth.util.HttpUtil;
import com.github.entropyfeng.simpleauth.util.JsonWebTokenUtil;
import com.github.entropyfeng.simpleauth.util.JwtAccount;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author entropyfeng
 */
public class AuthTokenInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenInterceptor.class);
    /**
     * build this interceptor support's annotations
     */
    private static final Set<String> SUPPORT_AUTH_ANNOTATION = new HashSet<String>() {{
        add(DeleteAuth.class.getName());
        add(GetAuth.class.getName());
        add(PutAuth.class.getName());
        add(PostAuth.class.getName());
        add(PutAuth.class.getName());
        add(AuthTokenRequired.class.getName());
    }};


    @Autowired
    AuthService authService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {


        boolean res = true;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Annotation[] annotations = handlerMethod.getMethod().getAnnotations();

            //check whether this method is should be handler by  this interceptor
            boolean support = Arrays.stream(annotations).anyMatch(annotation -> SUPPORT_AUTH_ANNOTATION.contains(annotation.annotationType().getName()));

            if (support) {
                String perm = getMethodPerm(handlerMethod);

                res=checkAuth(perm,request,response);
            }
        }

        return res;
    }

    private boolean checkAuth(String perm,HttpServletRequest request,HttpServletResponse response){

        boolean res=false;
        JwtAccount jwtAccount = parseRequest(request, response);
        if(jwtAccount!=null){
            List<String> roleList=null;
            try {
                roleList= JSON.parseArray(jwtAccount.getRoles(), String.class);
            }catch (JSONException e){
                logger.info("parse roleList error");
            }

            if(roleList!=null){
                if(!authService.checkPerm(roleList, perm)){
                    Message message=new Message();
                    message.setSuccess(false);
                    message.setMsg("auth error");
                    HttpUtil.writeJsonResponse(response,JSON.toJSONString(message));
                }else {
                    res=true;
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

    /**
     *
     * get this annotation requires perms
     * @param handlerMethod handlerMethod
     * @return NotNull
     * the annotation requires perm { consist with request resource and request method}
     */
    private String getMethodPerm(HandlerMethod handlerMethod) {
        String resource;
        String method;

        AuthTokenRequired authTokenRequired = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), AuthTokenRequired.class);
        if (StringUtils.isEmpty(authTokenRequired.value())) {
            method = authTokenRequired.method().name();
            //this auth framework only support these RequestMethod
            switch (authTokenRequired.method()) {

                case GET:
                    resource = handlerMethod.getMethod().getAnnotation(GetAuth.class).value();
                    break;
                case PUT:
                    resource = handlerMethod.getMethod().getAnnotation(PutAuth.class).value();
                    break;
                case DELETE:
                    resource = handlerMethod.getMethod().getAnnotation(DeleteAuth.class).value();
                    break;
                case PATCH:
                    resource = handlerMethod.getMethod().getAnnotation(PatchAuth.class).value();
                    break;
                case POST:
                    resource = handlerMethod.getMethod().getAnnotation(PostAuth.class).value();
                    break;
                default:
                    //you are not expected to access this
                    logger.error("Not support method " + authTokenRequired.method().name());
                    throw new Error("Not support method " + authTokenRequired.method().name());
            }
        } else {
            method = authTokenRequired.method().name();
            resource = authTokenRequired.value();
        }

        return resource + AuthProperties.resourceMethodJoint + method;
    }


}
