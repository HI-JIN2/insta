package com.instagram.instagramclonecoding.handler;

import com.instagram.instagramclonecoding.handler.ex.CustomValidationException;
import com.instagram.instagramclonecoding.web.dto.CMRespDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@ControllerAdvice
@RestController //데이터를 리턴
public class ControllerExceptionHanlder {

    @ExceptionHandler(CustomValidationException.class)
    public CMRespDto<?> validationException(CustomValidationException e){

        return new CMRespDto<Map<String,String>>(-1, e.getMessage(), e.getErrorMap());
    }


}
