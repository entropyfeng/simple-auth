package com.github.entropyfeng.simpleauth.data.status;

/**
 * @author entropyfeng
 * @date 2019/12/26 16:56
 */
public enum  RegisterStatus {
    //默认拒绝
    REJECT,
    //主体重复
    PRINCIPAL_DUPLICATED,
    //凭证格式错误
    //CREDENTIAL_FORMAT_ERROR
}
