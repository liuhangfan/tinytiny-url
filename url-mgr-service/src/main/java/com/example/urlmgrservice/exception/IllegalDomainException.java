package com.example.urlmgrservice.exception;

public class IllegalDomainException extends BaseException{
    public IllegalDomainException() {
    }

    public IllegalDomainException(String message) {
        super(message);
    }

    public IllegalDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalDomainException(Throwable cause) {
        super(cause);
    }

    public IllegalDomainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
