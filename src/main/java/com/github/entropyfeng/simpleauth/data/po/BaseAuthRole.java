package com.github.entropyfeng.simpleauth.data.po;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 验证角色基础类
 * @author entropyfeng
 *
 */
public class BaseAuthRole {



    @NotNull
    private Integer roleId;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;

    private String roleStatus;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }
}
