package com.example.urlmgrservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import static com.example.urlmgrservice.UrlMgrServiceApplication.LOGGER;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TinyUrlNotFoundException.class)
    public ResponseEntity<?> tinyUrlNotFoundExceptionHandling(Exception exception, WebRequest request) {
        LOGGER.info("tinyUrl not found", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), exception.getMessage(),
                        request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AliasDuplicateException.class)
    public ResponseEntity<?> aliasDuplicateExceptionHandling(Exception exception, WebRequest request) {
        LOGGER.info("alias duplicate", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), exception.getMessage(),
                        request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<?> internalExceptionHandling(Exception exception, WebRequest request) {
        LOGGER.warn("internal exception", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), exception.getMessage(),
                        request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalAliasException.class)
    public ResponseEntity<?> illegalAliasExceptionHandling(Exception exception, WebRequest request) {
        LOGGER.info("alias is illegal", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), exception.getMessage(),
                        request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalUrlException.class)
    public ResponseEntity<?> illegalUrlException(Exception exception, WebRequest request){
        LOGGER.info("url is invalid", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), exception.getMessage(),
                        request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }
}
