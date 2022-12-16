package com.example.urlmgrservice.exception;

public class AliasDuplicateException extends BaseException {
    public AliasDuplicateException() {
    }

    public AliasDuplicateException(String message) {
        super(message);
    }

    public AliasDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public AliasDuplicateException(Throwable cause) {
        super(cause);
    }

    public AliasDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
