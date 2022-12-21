package com.example.urlmgrservice.controller;


import com.example.urlmgrservice.domain.dto.RedirectCreator;
import com.example.urlmgrservice.domain.vo.CreatorResult;
import com.example.urlmgrservice.entity.TinyDoc;
import com.example.urlmgrservice.exception.TooManyRequestException;
import com.example.urlmgrservice.service.RateLimitService;
import com.example.urlmgrservice.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import static com.example.urlmgrservice.UrlMgrServiceApplication.LOGGER;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RedirectController {
    private final RedirectService redirectService;
    private final RateLimitService rateLimiter;

    @Autowired
    public RedirectController(RedirectService redirectService, RateLimitService rateLimiter) {
        this.redirectService = redirectService;
        this.rateLimiter = rateLimiter;
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> handelRedirect(@PathVariable String alias) throws URISyntaxException {
        if(!rateLimiter.tryAcquire()){
            throw new TooManyRequestException("Service is busy now, try it later");
        }
        TinyDoc tinyDoc = redirectService.getTinyDoc(alias);
        URI uri = new URI(tinyDoc.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        LOGGER.info("handel redirect success, input: {} , output: {}", alias, uri.toString());
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @PostMapping("/")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreator redirectCreator) {
        if(!rateLimiter.tryAcquire()){
            throw new TooManyRequestException("Service is busy now, try it later");
        }
        CreatorResult result = redirectService.createTinyUrl(redirectCreator);
        LOGGER.info("create redirect, input: {} , output: {}", redirectCreator, result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
