package com.github.entropyfeng.simpleauthinstance.domain.vo;

/**
 * @author entropyfeng
 * @date 2019/12/31 17:09
 */
public class RolesAndItsResources {

    private String roleName;
    private String resourceMethod;
    private String resourceContent;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getResourceMethod() {
        return resourceMethod;
    }

    public void setResourceMethod(String resourceMethod) {
        this.resourceMethod = resourceMethod;
    }

    public String getResourceContent() {
        return resourceContent;
    }

    public void setResourceContent(String resourceContent) {
        this.resourceContent = resourceContent;
    }
}
