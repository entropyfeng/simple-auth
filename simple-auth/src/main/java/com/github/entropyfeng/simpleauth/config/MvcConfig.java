package com.github.entropyfeng.simpleauth.config;

import com.github.entropyfeng.simpleauth.config.interceptor.AuthTokenInterceptor;
import com.github.entropyfeng.simpleauth.config.interceptor.KaptchaInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC 配置类
 * @author entropyfeng
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private static final Logger logger=LoggerFactory.getLogger(MvcConfig.class);

    @Bean
    KaptchaInterceptor kaptchaInterceptor(){
        return new KaptchaInterceptor();
    }

    @Bean
    AuthTokenInterceptor authTokenInterceptor(){
        return new AuthTokenInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        logger.info("add kaptchaInterceptor into config");
        registry.addInterceptor(authTokenInterceptor()).order(0);
        registry.addInterceptor(kaptchaInterceptor()).order(1);


    }
}
