package com.github.entropyfeng.begauth.event;

import org.springframework.context.ApplicationEvent;
import java.util.List;
/**
 * @author entropyfeng
 * @date 2019/6/12 19:04
 */
public class PermCheckEvent extends ApplicationEvent {



    private List<String> roleList;
    private String perm;
    public PermCheckEvent(Object source,List<String> roleList,String perm) {
        super(source);
        this.perm=perm;
        this.roleList=roleList;
    }
    public List<String> getRoleList() {
        return roleList;
    }

    public String getPerm() {
        return perm;
    }
}
