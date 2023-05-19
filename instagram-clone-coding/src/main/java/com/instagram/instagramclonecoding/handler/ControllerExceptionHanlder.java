package com.instagram.instagramclonecoding.handler;

import com.instagram.instagramclonecoding.handler.ex.CustomApiException;
import com.instagram.instagramclonecoding.handler.ex.CustomValidationApiException;
import com.instagram.instagramclonecoding.handler.ex.CustomValidationException;
import com.instagram.instagramclonecoding.util.Script;
import com.instagram.instagramclonecoding.web.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@ControllerAdvice
@RestController //데이터를 리턴
public class ControllerExceptionHanlder {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e){
        //CMRespDto, Script 비교
        //1. 클라이언트에게 응답할때는 script 좋음
        //2. Ajax 통신 -CMRespDto
        //3. 안드로이드 통신 -CMRespDto
        return Script.back(e.getMessage().toString());
    }


    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationApiException(CustomValidationApiException e){
        return new ResponseEntity<>(new CMRespDto<>(-1,e.getMessage(),e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException e){
        return new ResponseEntity<>(new CMRespDto<>(-1,e.getMessage(),null), HttpStatus.BAD_REQUEST);
    }
}
