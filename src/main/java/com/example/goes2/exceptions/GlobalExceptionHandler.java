package com.example.goes2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(EmailAlreadySubscribed.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String emailAlreadySubscribedHandler(EmailAlreadySubscribed e){
        return e.getMessage();
    }
}
