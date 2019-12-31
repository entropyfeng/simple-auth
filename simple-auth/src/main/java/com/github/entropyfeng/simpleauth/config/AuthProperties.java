package com.github.entropyfeng.simpleauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author entropyfeng
 * @date 2019/6/12 18:16
 */
@Component
@ConfigurationProperties(prefix = "simple-auth")
public class AuthProperties {



    public static String jwtSecretKey = "?::43dsd43fdf4fdf48487456cvf):";
    public static String authTokenName="auth_token";
    public static String kaptchaSuffix="KAPTCHA_TOKEN_";
    public static String authRoleSuffix="AUTH_ROLE_";
    public static String resourceMethodJoint="==";
    public static Long machineId=1L;
    public static Long dataCenterId=1L;
    /**
     * the expired time of the kaptcha
     */
    public static Integer kaptchaExpiredTime=300;

    public  Long getDataCenterId() {
        return dataCenterId;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        AuthProperties.machineId = machineId;
    }

    public  void setDataCenterId(Long dataCenterId) {
        AuthProperties.dataCenterId = dataCenterId;
    }

    public String getJwtSecretKey() {
        return jwtSecretKey;
    }

    public void setJwtSecretKey(String jwtSecretKey) {
        AuthProperties.jwtSecretKey = jwtSecretKey;
    }

    public String getAuthTokenName() {
        return authTokenName;
    }

    public void setAuthTokenName(String authTokenName) {
        AuthProperties.authTokenName = authTokenName;
    }

    public Integer getKaptchaExpiredTime() {
        return kaptchaExpiredTime;
    }

    public void setKaptchaExpiredTime(Integer kaptchaExpiredTime) {
        AuthProperties.kaptchaExpiredTime = kaptchaExpiredTime;
    }

    public String getKaptchaSuffix() {
        return kaptchaSuffix;
    }

    public void setKaptchaSuffix(String kaptchaSuffix) {
       AuthProperties.kaptchaSuffix = kaptchaSuffix;
    }


    public String getAuthRoleSuffix() {
        return authRoleSuffix;
    }

    public void setAuthRoleSuffix(String authRoleSuffix) {
       AuthProperties.authRoleSuffix = authRoleSuffix;
    }

    public String getResourceMethodJoint() {
        return resourceMethodJoint;
    }

    public void setResourceMethodJoint(String resourceMethodJoint) {
        AuthProperties.resourceMethodJoint = resourceMethodJoint;
    }
}
