package com.example.urlmgrservice.exception;

public class TooManyRequestException extends BaseException{
    public TooManyRequestException() {
    }

    public TooManyRequestException(String message) {
        super(message);
    }

    public TooManyRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyRequestException(Throwable cause) {
        super(cause);
    }

    public TooManyRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
