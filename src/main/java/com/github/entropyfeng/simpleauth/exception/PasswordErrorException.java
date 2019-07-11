package com.github.entropyfeng.simpleauth.exception;

/**
 * @author entropyfeng
 * @date 2019/7/4 11:39
 */
public class PasswordErrorException extends CredentialErrorException {
    public PasswordErrorException() {
        super();
    }


    public PasswordErrorException(String message) {
        super(message);
    }


    public PasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }


    public PasswordErrorException(Throwable cause) {
        super(cause);
    }


    protected PasswordErrorException(String message, Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
