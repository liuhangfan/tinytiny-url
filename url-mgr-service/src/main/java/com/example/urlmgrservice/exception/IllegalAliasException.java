package com.example.urlmgrservice.exception;

public class IllegalAliasException extends BaseException {
    public IllegalAliasException() {
    }

    public IllegalAliasException(String message) {
        super(message);
    }

    public IllegalAliasException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAliasException(Throwable cause) {
        super(cause);
    }

    public IllegalAliasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
