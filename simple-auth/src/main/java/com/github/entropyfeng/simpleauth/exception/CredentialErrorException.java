package com.github.entropyfeng.simpleauth.exception;

/**
 * @author entropyfeng
 * @date 2019/7/10 20:49
 */
public class CredentialErrorException extends Exception {
    public CredentialErrorException() {
        super();
    }


    public CredentialErrorException(String message) {
        super(message);
    }


    public CredentialErrorException(String message, Throwable cause) {
        super(message, cause);
    }


    public CredentialErrorException(Throwable cause) {
        super(cause);
    }


    protected CredentialErrorException(String message, Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
