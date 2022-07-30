package com.example.goes2.web;

import com.example.goes2.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RateController {
    private final RateService service;

    @Autowired
    public RateController(RateService service) {
        this.service = service;
    }

    @GetMapping("/rate")
    int getBTCtoUAH(){
        return (int) service.getRate().getPrice();
    }
}
