package com.example.urlmgrservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlMgrServiceApplication {
    public static final Logger LOGGER = LogManager.getLogger(UrlMgrServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UrlMgrServiceApplication.class, args);
    }
}
