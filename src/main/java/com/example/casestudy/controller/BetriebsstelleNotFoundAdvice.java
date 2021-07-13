package com.example.casestudy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BetriebsstelleNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BetriebsstelleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String betriebsstelleNotFoundHandler(BetriebsstelleNotFoundException ex){
        return ex.getMessage();
    }

}
