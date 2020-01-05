package com.github.entropyfeng.simpleauth.config;

/**
 * 常量类
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

    /**
     * HttpRequest 中以何种方式登录系统
     */
    public static final String LOGIN_METHOD="login_method";

    /**
     * Json web token secret
     */
    public static final String JWT_SECRET_KEY="e7QW8LL;qe$^&^*&!#$>?wq";

    /**
     * RSA secret
     */
    @SuppressWarnings("all")
    public static final String RSA_SECRET_KEY="7&&%@!:>?<|\\}Q450*FDs48df0o+-ycn";

    /**
     * 全局唯一user id
     */
    public static String GLOBAL_USER_ID_NAME="GLOBAL_UID";

    /**
     * 全局唯一role id
     */
    public static String GLOBAL_ROLE_ID_NAME="GLOBAL_UID";

    /**
     * 全局唯一resource id
     */
    public static String GLOBAL_RESOURCE_ID_NAME="GLOBAL_UID";

}
