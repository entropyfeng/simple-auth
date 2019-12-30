package com.github.entropyfeng.simpleauth.data.status;

/**
 * @author entropyfeng
 * @date 2019/7/3 22:37
 */
public enum PrincipalStatus {
    //默认拒绝
    REJECT,
    //登录成功
    SUCCESS,
    //Principal与Credential 不匹配
    PRINCIPAL_CREDENTIAL_NOT_CORRESPOND,
    //账户被禁用
    PRINCIPAL_DISABLE,
    //账户不存在
    PRINCIPAL_NOT_EXIST,
    //尝试次数超限
    PRINCIPAL_TRY_OUT_OF_LIMITED

}
