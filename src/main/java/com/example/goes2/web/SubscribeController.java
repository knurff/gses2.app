package com.example.goes2.web;

import com.example.goes2.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscribeController {

    private final SubscribeService service;

    @Autowired
    public SubscribeController(SubscribeService service) {
        this.service = service;
    }

    @PostMapping("/subscribe")
    void subscribe(@RequestBody String email) {
        service.subscribe(email.trim());
    }

    @PostMapping("/sendEmails")
    List<String> sendEmails() {
        return service.sendEmails();
    }
}
