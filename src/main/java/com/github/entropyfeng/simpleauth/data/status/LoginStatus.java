package com.github.entropyfeng.simpleauth.data.status;

/**
 * @author entropyfeng
 * @date 2019/7/3 22:37
 */
public enum LoginStatus {
    //默认拒绝
    DEFAULT,
    //登录成功
    SUCCESS,
    //密码错误
    PASSWORD_ERROR,
    //账户被禁用
    ACCOUNT_DISABLE,
    //账户不存在
    ACCOUNT_NOT_EXIST,
    //尝试登录次数超限
    ACCOUNT_LOGIN_OUT_OF_LIMITED

}
