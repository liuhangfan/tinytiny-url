package com.example.urlmgrservice.controller;


import com.example.urlmgrservice.domain.dto.RedirectCreator;
import com.example.urlmgrservice.entity.TinyDoc;
import com.example.urlmgrservice.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class RedirectController {
    private final RedirectService redirectService;

    @Autowired
    public RedirectController(RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> handelRedirect(@PathVariable String alias) throws URISyntaxException {
        try {
            TinyDoc tinyDoc = redirectService.getTinyDoc(alias);
            URI uri = new URI(tinyDoc.getUrl());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uri);
            return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectCreator redirectCreator) {
        try{
            TinyDoc tinyDoc = redirectService.createTinyDoc(redirectCreator);
            return new ResponseEntity<>(tinyDoc,HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
