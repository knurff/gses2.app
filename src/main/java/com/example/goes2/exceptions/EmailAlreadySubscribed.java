package com.example.goes2.exceptions;

public class EmailAlreadySubscribed extends RuntimeException {
    public EmailAlreadySubscribed(String message) {
        super(message);
    }
}
