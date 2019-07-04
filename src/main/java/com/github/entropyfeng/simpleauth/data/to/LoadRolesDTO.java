package com.github.entropyfeng.simpleauth.data.to;
import java.util.Set;

/**
 * @author entropyfeng
 * @date 2019/7/4 11:09
 */
public class LoadRolesDTO {

    public LoadRolesDTO(Long userId){
        this.userId=userId;
    }
    private Long userId;
    private Set<String> roles;

    public Long getUserId() {
        return userId;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "LoadRolesDTO{" + "userId='" + userId + '\'' + ", roles=" + roles + '}';
    }
}
