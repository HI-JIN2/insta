package com.instagram.instagramclonecoding.web.api;

import com.instagram.instagramclonecoding.config.auth.PrincipalDetails;
import com.instagram.instagramclonecoding.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SubscribeService;

@RequiredArgsConstructor
@RestController
public class SubscribeApiController {

    private final SubscribeService subscribeService;

    @PostMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId){
        subscribeService.구독하기(Math.toIntExact(principalDetails.getUser().getId()),toUserId);
        return new ResponseEntity<>(new CMRespDto<>(1,"구독하기 성공",null), HttpStatus.OK);
    }

    @DeleteMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> unSubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId){
        subscribeService.구독하기(Math.toIntExact(principalDetails.getUser().getId()),toUserId);
        return new ResponseEntity<>(new CMRespDto<>(1,"구독 취소하기 성공",null), HttpStatus.OK);
    }
}
