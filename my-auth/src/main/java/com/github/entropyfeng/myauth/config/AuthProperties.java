package com.github.entropyfeng.myauth.config;

/**
 * @author entropyfeng
 * @date 2019/12/30 17:37
 */
public class AuthProperties {

    /**
     * Resource的方法名与URL的连接字符串
     */
    public static final String RESOURCE_METHOD_JOINT="==";

    /**
     * MD5+salt
     */
    public static final String SALT="}@&_6QdP,.>OmCdB";

    /**
     * 存放在Redis中的角色前缀
     */
    public static final String AUTH_ROLE_SUFFIX="";


    /**
     * HttpRequest 中需要读取的token名称
     */
    public static final String AUTH_TOKEN_NAME="auth_token";

    public static final String JWT_SECRET_KEY="e7QW8LL;qe$^&^*&!#$>?wq";
}
