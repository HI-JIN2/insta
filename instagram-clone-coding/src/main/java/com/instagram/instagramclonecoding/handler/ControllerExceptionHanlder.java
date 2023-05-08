package com.instagram.instagramclonecoding.handler;

import com.instagram.instagramclonecoding.handler.ex.CustomValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@ControllerAdvice
@RestController //데이터를 리턴
public class ControllerExceptionHanlder {

    @ExceptionHandler(CustomValidationException.class)
    public Map<String,String> validationException(CustomValidationException e){

        return e.getErrorMap();
    }


}
