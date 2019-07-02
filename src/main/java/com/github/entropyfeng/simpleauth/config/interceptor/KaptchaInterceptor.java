package com.github.entropyfeng.simpleauth.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.github.entropyfeng.simpleauth.config.anno.KaptchaRequired;
import com.github.entropyfeng.simpleauth.data.vo.Message;
import com.github.entropyfeng.simpleauth.service.KaptchaService;
import com.github.entropyfeng.simpleauth.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author entropyfeng
 * 图形验证码拦截器
 */
public class KaptchaInterceptor implements HandlerInterceptor {

    @Autowired
    KaptchaService kaptchaService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean res = true;
        if (handler instanceof HandlerMethod) {


            HandlerMethod handlerMethod = (HandlerMethod) handler;
            KaptchaRequired kaptchaRequired = handlerMethod.getMethod().getAnnotation(KaptchaRequired.class);

            if (kaptchaRequired != null) {
                if (!checkKaptcha(request)) {
                    res = false;
                    Message message = new Message();
                    message.setSuccess(false);
                    message.setMsg("Kaptcha auth error!");
                    HttpUtil.writeJsonResponse(response, JSON.toJSONString(message));
                }
            }
        }
        return res;

    }

    private boolean checkKaptcha(HttpServletRequest request) {

        String kaptchaToken = request.getParameter("kaptcha_token");
        String kaptcha = request.getParameter("kaptcha");
        return   kaptchaService.checkKaptcha(kaptchaToken,kaptcha);
    }


}
