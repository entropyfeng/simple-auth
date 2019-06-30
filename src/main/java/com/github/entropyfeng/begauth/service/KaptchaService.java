package com.github.entropyfeng.begauth.service;

import java.util.Map;

/**
 * @author entropyfeng
 * @date 2019/6/9 21:33
 */
public interface KaptchaService {
    /**
     * 创建了一个Kaptcha相关map
     * 返回空代表创建失败
     *
     * @return {  aMap
     *
     *     key            value
     *     img            经过Base64编码后的图片
     *     kaptcha_token  the key of kaptcha
     * }
     *
     */
    public Map createKaptcha();

    /**
     * 检查Kaptcha 是否正确
     * @param kaptchaToken the key of kaptcha
     * @param  kaptcha the value of kaptcha
     * @return false-> check incorrectly ;true->check correctly
     *
     */
    public boolean checkKaptcha(String kaptchaToken,String kaptcha);
}
