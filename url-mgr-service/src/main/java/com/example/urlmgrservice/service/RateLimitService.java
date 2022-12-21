package com.example.urlmgrservice.service;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class RateLimitService {
    RateLimiter rateLimiter;

    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }

    public RateLimitService() {
        rateLimiter = RateLimiter.create(10.0);
    }
}
