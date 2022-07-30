package com.example.goes2.service;

import com.example.goes2.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class RateService {
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);

    private final WebClient localApiClient;

    @Autowired
    public RateService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }

    public Rate getRate(){
        return localApiClient
                .get()
                .uri("/ticker/price?symbol=" + "BTCUAH")
                .retrieve()
                .bodyToMono(Rate.class)
                .block(REQUEST_TIMEOUT);
    }
}
