package com.example.urlmgrservice.exception;

public class TinyUrlNotFoundException extends BaseException {
    public TinyUrlNotFoundException() {
    }

    public TinyUrlNotFoundException(String message) {
        super(message);
    }

    public TinyUrlNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TinyUrlNotFoundException(Throwable cause) {
        super(cause);
    }

    public TinyUrlNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
