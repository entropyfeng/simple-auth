package com.github.entropyfeng.simpleauth.exception;

/**
 * @author entropyfeng
 * @date 2019/7/4 11:39
 */
public class AccountNotExistException extends PrincipalNotExistException {
    public AccountNotExistException() {
        super();
    }


    public AccountNotExistException(String message) {
        super(message);
    }


    public AccountNotExistException(String message, Throwable cause) {
        super(message, cause);
    }


    public AccountNotExistException(Throwable cause) {
        super(cause);
    }


    protected AccountNotExistException(String message, Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
