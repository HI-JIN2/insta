package com.example.insta.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller //File을 응답하는 컨트롤러(클라이언트가 브라우저면 html 파일을)
@RestController //Data를 응답하는 컨트롤러(클라이언트가 핸드폰이면 data)
public class HttpController {


    // http://localhost:8080
    @GetMapping("/get")
    public String get(){
//        return "a.html";
        //바꾸자마자 되는거 스프링 데브툴

        return "<h1>get 요청됨</h1>";
    }

    @PostMapping("/post")
    public String post(){
        return "post 요청됨";
    }

    @PutMapping("/put")
    public String put(){
        return "put 요청됨";
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "delete 요청됨";
    }

}
