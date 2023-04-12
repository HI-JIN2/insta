package com.example.insta.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpRedirectionController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/away")
    public String away(){
        return "redirect:/home";  //리다이렉션(재분배)된다.
        //컨트롤러만 됨. 레스트 컨트롤러는 안됨? 왜?
        //레스트 컨트롤러에 포함되는 개념이 아닌가?
    }
}
