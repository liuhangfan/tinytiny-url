package com.example.urlmgrservice.service;


import com.example.urlmgrservice.entity.Redirect;
import com.example.urlmgrservice.entity.RedirectCreator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {

    public Optional<Redirect> createRedirect(RedirectCreator redirectCreator) {
        return null;
    }

    public Redirect getRedirect(String alias) {
        return null;
    }
}
