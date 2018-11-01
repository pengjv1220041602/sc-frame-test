package com.sc;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer () {
        return new Retryer.Default(100, 1000, 2);
    }
}
