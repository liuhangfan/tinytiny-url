package com.example.urlmgrservice.controller;


import com.example.urlmgrservice.entity.RedirectResult;
import com.example.urlmgrservice.domain.dto.RedirectCreator;
import com.example.urlmgrservice.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;


@RestController
public class RedirectController {
    private RedirectService redirectService;

    @Autowired
    public RedirectController(RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> handelRedirect(@PathVariable String alias) throws URISyntaxException {
        RedirectResult redirectResult = redirectService.getRedirect(alias);
        URI uri = new URI(redirectResult.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreator redirectCreator) {
        return ResponseEntity.ok(redirectService.createRedirect(redirectCreator));
    }
}
