package com.example.urlmgrservice.exception;

public class IllegalUrlException extends BaseException{
    public IllegalUrlException() {
    }

    public IllegalUrlException(String message) {
        super(message);
    }

    public IllegalUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalUrlException(Throwable cause) {
        super(cause);
    }

    public IllegalUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
