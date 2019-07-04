package com.github.entropyfeng.simpleauth.event;

import com.github.entropyfeng.simpleauth.data.to.LoadRolesDTO;
import org.springframework.context.ApplicationEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author entropyfeng
 * @date 2019/7/4 11:07
 * 发布一个加载用户所包含的角色的事件
 */
public class LoadUserRolesEvent extends ApplicationEvent {
    private LoadRolesDTO loadRolesDTO;
    public LoadUserRolesEvent(Object source,LoadRolesDTO loadRolesDTO) {
        super(source);
        this.loadRolesDTO=loadRolesDTO;
        loadRolesDTO.setRoles(new HashSet<>());
    }

    public Long getUserId(){
        return loadRolesDTO.getUserId();
    }
    public Set<String> getRoles(){
        return loadRolesDTO.getRoles();
    }
    public void addRole(String role){
        loadRolesDTO.getRoles().add(role);
    }
    public void addRoles(Set<String> roles){
        loadRolesDTO.getRoles().addAll(roles);
    }

}
