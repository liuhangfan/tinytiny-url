package com.example.urlmgrservice.utils;

import com.example.urlmgrservice.utils.UUID.Snowflake;
import com.example.urlmgrservice.utils.UUID.UUIDGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingletonUtils {

    @Bean
    @Scope("singleton")
    public UUIDGenerator SnowflakeUUIDGenerator() {
        return new Snowflake();
    }

}
