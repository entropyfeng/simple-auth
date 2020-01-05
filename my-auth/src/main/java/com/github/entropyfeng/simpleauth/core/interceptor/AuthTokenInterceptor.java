package com.github.entropyfeng.simpleauth.core.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.github.entropyfeng.simpleauth.config.AuthProperties;
import com.github.entropyfeng.simpleauth.config.anno.*;
import com.github.entropyfeng.simpleauth.data.vo.Message;
import com.github.entropyfeng.simpleauth.service.AuthService;
import com.github.entropyfeng.simpleauth.util.HttpUtil;
import com.github.entropyfeng.simpleauth.util.JsonWebTokenUtil;
import com.github.entropyfeng.simpleauth.data.to.JwtAccount;
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
    private AuthService authService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean res = true;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String perm = handleMethod(handlerMethod);
            if (perm != null) {
                res = checkAuth(perm, request, response);
            }
        }

        return res;
    }

    /**
     * 找到该 handler所需要的权限
     *
     * @param handlerMethod {@link HandlerMethod}
     * @return null->不是所要拦截的行为
     * String->该方法所需要的权限信息
     */
    private String handleMethod(HandlerMethod handlerMethod) {

        Annotation[] annotations = handlerMethod.getMethod().getAnnotations();
        boolean isGet = Arrays.stream(annotations).anyMatch(annotation -> GetAuth.class.getName().equals(annotation.annotationType().getName()));
        if (isGet) {
            return "GET" + AuthProperties.RESOURCE_METHOD_JOINT + handlerMethod.getMethodAnnotation(GetAuth.class).value();
        }
        boolean isPost = Arrays.stream(annotations).anyMatch(annotation -> PostAuth.class.getName().equals(annotation.annotationType().getName()));

        if (isPost) {
            return "POST" + AuthProperties.RESOURCE_METHOD_JOINT + handlerMethod.getMethodAnnotation(PostAuth.class);
        }
        boolean isPut = Arrays.stream(annotations).anyMatch(annotation -> PutAuth.class.getName().equals(annotation.annotationType().getName()));

        if (isPut) {
            return "PUT" + AuthProperties.RESOURCE_METHOD_JOINT + handlerMethod.getMethodAnnotation(PutAuth.class);
        }
        boolean isDelete = Arrays.stream(annotations).anyMatch(annotation -> DeleteAuth.class.getName().equals(annotation.annotationType().getName()));
        if (isDelete) {
            return "DELETE" + AuthProperties.RESOURCE_METHOD_JOINT + handlerMethod.getMethodAnnotation(DeleteAuth.class);
        }

        boolean isPatch = Arrays.stream(annotations).anyMatch(annotation -> PatchAuth.class.getName().equals(annotation.annotationType().getName()));

        if (isPatch) {
            return "PATCH" + AuthProperties.RESOURCE_METHOD_JOINT + handlerMethod.getMethodAnnotation(PatchAuth.class);
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
                logger.info("token {} parse roleList error", jwtAccount.getTokenId());
            }

            if (roleList != null) {
                if (!authService.checkPerm(roleList, perm)) {
                    Message message = new Message();
                    message.setSuccess(false);
                    message.setMsg("don't have the privilege");
                    HttpUtil.writeJsonResponse(response, JSON.toJSONString(message));
                } else {
                    res = true;
                }
            } else {
                Message message = new Message();
                message.setSuccess(false);
                message.setMsg("illegal token !");
            }
        }
        return res;
    }

    /**
     * 解析Request中的token ,若合法则返回代表该token的对象
     * 若非法则返回空，并向客户发送错误信息
     *
     * @param request  {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     * @return {@link JwtAccount}
     */
    private JwtAccount parseRequest(HttpServletRequest request, HttpServletResponse response) {

        String authToken = HttpUtil.getToFind(request, AuthProperties.AUTH_TOKEN_NAME);
        Message message = new Message();
        JwtAccount jwtAccount = null;
        //检查request中是否携带token
        if (!StringUtils.isEmpty(authToken)) {
            try {
                jwtAccount = JsonWebTokenUtil.parseJwt(authToken, AuthProperties.JWT_SECRET_KEY);
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
            //request 中没有携带token

            message.setSuccess(false);
            message.setMsg("required " + AuthProperties.AUTH_TOKEN_NAME);

        }

        if (jwtAccount == null) {
            HttpUtil.writeJsonResponse(response, JSON.toJSONString(message));
        }


        return jwtAccount;
    }
    //-------------get and set------------


    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
