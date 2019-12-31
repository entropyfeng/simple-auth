package com.github.entropyfeng.simpleauthinstance.domain.bo;

import java.util.Date;

/**
 * @author entropyfeng
 * @date 2019/12/30 21:08
 */
public class AuthRole {
    private int roleId;
    private String roleName;
    private int status;
    private String description;
    private Date createTime;
    private  Date  updateTime;


   //--------------------get and set----------------------------



    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }




}
