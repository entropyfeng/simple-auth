package com.github.entropyfeng.myauth.exception;

/**
 * @author entropyfeng
 * @date 2019/7/10 20:50
 */
public class PrincipalExpiredException extends Exception {
    public PrincipalExpiredException() {
        super();
    }


    public PrincipalExpiredException(String message) {
        super(message);
    }


    public PrincipalExpiredException(String message, Throwable cause) {
        super(message, cause);
    }


    public PrincipalExpiredException(Throwable cause) {
        super(cause);
    }


    protected PrincipalExpiredException(String message, Throwable cause,
                                         boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
