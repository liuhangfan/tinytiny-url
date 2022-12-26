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
                new ErrorDetail(new Date(), "tinyUrl not found",
                        request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AliasDuplicateException.class)
    public ResponseEntity<?> aliasDuplicateExceptionHandling(Exception exception, WebRequest request) {
        LOGGER.info("alias duplicate", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), "alias is already exists",
                        request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<?> internalExceptionHandling(Exception exception, WebRequest request) {
        LOGGER.warn("internal exception", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), "Sorry, the server is busy. Please try again later",
                        request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalAliasException.class)
    public ResponseEntity<?> illegalAliasExceptionHandling(Exception exception, WebRequest request) {
        LOGGER.info("alias is invalid", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), "alias is invalid",
                        request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalUrlException.class)
    public ResponseEntity<?> illegalUrlException(Exception exception, WebRequest request){
        LOGGER.info("url is invalid", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), "please check your url",
                        request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TooManyRequestException.class)
    public ResponseEntity<?> tooManyRequestException(Exception exception, WebRequest request){
        LOGGER.info("too many request", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), "too many request",
                        request.getDescription(false)), HttpStatus.TOO_MANY_REQUESTS);
    }

    @ExceptionHandler(IllegalDomainException.class)
    public ResponseEntity<?> IllegalDomainException(Exception exception, WebRequest request){
        LOGGER.info("domain is invalid", exception);
        return new ResponseEntity<>(
                new ErrorDetail(new Date(), "domain is invalid",
                        request.getDescription(false)), HttpStatus.TOO_MANY_REQUESTS);
    }
}
