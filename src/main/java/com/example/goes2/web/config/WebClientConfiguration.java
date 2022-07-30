package com.example.goes2.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Bean
    public WebClient localApiClient() {
        return WebClient.create("https://www.binance.com/api/v3");
    }
}
