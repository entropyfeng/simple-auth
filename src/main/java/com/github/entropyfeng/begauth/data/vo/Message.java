package com.github.entropyfeng.begauth.data.vo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author entropyfeng
 * @date 2019.6.9
 */
public class Message implements Serializable {


    private boolean success;
    private String msg;
    private String code;
    private HashMap<String,String> params=new HashMap<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }
    public void addParams(String key,String value){
        this.params.put(key,value);
    }
}
