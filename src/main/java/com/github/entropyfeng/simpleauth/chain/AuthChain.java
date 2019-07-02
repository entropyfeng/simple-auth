package com.github.entropyfeng.simpleauth.chain;
import java.util.List;
/**
 * @author entropyfeng
 * @date 2019/6/13 12:37
 */
public abstract class AuthChain {

    public boolean checkPerm(List<String> roleList,String perm){

        return false;
    }
}
