package com.github.entropyfeng.simpleauth.exception;

/**
 * @author entropyfeng
 * @date 2019/7/10 20:46
 */
public class PrincipalNotExistException extends Exception {
    public PrincipalNotExistException() {
        super();
    }


    public PrincipalNotExistException(String message) {
        super(message);
    }


    public PrincipalNotExistException(String message, Throwable cause) {
        super(message, cause);
    }


    public PrincipalNotExistException(Throwable cause) {
        super(cause);
    }


    protected PrincipalNotExistException(String message, Throwable cause,
                                         boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
