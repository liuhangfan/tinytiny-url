package com.example.urlmgrservice.service;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class RateLimitService {
    RateLimiter rateLimiter = RateLimiter.create(60.0);

    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }

    public RateLimitService() {

    }
}
