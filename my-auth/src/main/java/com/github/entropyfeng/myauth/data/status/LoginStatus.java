package com.github.entropyfeng.myauth.data.status;

/**
 * @author entropyfeng
 * @date 2019/7/3 22:37
 */
public enum LoginStatus {
    //默认拒绝
    REJECT,
    //登录成功
    SUCCESS,
    //密码错误
    CREDENTIAL_ERROR,
    //账户被禁用
    PRINCIPAL_DISABLE,
    //账户不存在
    PRINCIPAL_NOT_EXIST,
    //尝试登录次数超限
    PRINCIPAL_LOGIN_OUT_OF_LIMITED

}
