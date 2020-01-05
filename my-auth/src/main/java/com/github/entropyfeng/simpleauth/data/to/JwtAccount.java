package com.github.entropyfeng.simpleauth.data.to;

import java.io.Serializable;
import java.util.Date;

/**
 * jwt account
 * @author entropyfeng
 */
public class JwtAccount implements Serializable {

    private static final long serialVersionUID = -895875540581785581L;

    /**
     * 令牌id
     */
    private String tokenId;

    /**
     * 用户标识
     */
    private String userId;
    /**
     * 签发者(JWT令牌此项有值)
     */
    private String issuer;
    /**
     * 签发时间
     */
    private Date issuedTime;


    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 接收方(JWT令牌此项有值)
     */
    private String audience;
    /**
     * 访问主张-角色
     */
    private String roles;
    /**
     * 访问主张-资源(JWT令牌此项有值)
     */
    private String perms;

    /**
     * 客户地址,可以是用户的ip地址
     */
    private String host;

    public JwtAccount() {

    }
    public JwtAccount(String tokenId, String userId, String issuer, Date issuedTime, String audience, String roles, String perms, String host) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.issuer = issuer;
        this.issuedTime =issuedTime;
        this.audience = audience;
        this.roles = roles;
        this.perms = perms;
        this.host = host;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId=userId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }


    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}