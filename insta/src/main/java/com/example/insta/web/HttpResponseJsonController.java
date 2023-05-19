package com.example.insta.web;

import com.example.insta.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpResponseJsonController {
    @GetMapping("/resp/json")
    public String respJson(){
        return "{\"username\":\"cos\"}";
    }

    @GetMapping("/resp/json/object")
    public User respJsonObject(){
        User user = new User();
        user.setUsername("홍길동");
        return user;
    }

}
